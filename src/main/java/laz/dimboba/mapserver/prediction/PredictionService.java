package laz.dimboba.mapserver.prediction;

import laz.dimboba.mapserver.exceptions.NotFoundException;
import laz.dimboba.mapserver.office.OfficeRepository;
import laz.dimboba.mapserver.office.data.OfficeDataRepository;
import laz.dimboba.mapserver.utils.DayOfTheWeek;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.UUID;

@Service
@AllArgsConstructor
public class PredictionService {
    private final PredictionRepository predictionRepository;
    private final OfficeDataRepository officeDataRepository;
    private final OfficeRepository officeRepository;
    private final long averageUsedTime = 26;
    public void updatePrediction(UUID officeId, int time, DayOfTheWeek day) {
        var data = officeDataRepository.findAllByOfficeIdAndTimeAndDay(officeId, time, day);
        var prediction = predictionRepository.findByOfficeIdAndTimeAndDay(officeId, time, day)
            .orElse(
                Prediction.builder()
                    .day(day)
                    .time(time)
                    .officeId(officeId)
                    .build()
            );
        Collections.sort(data);

        float median;

        if(data.size() % 2 != 0) {
            median = data.get(data.size()/2).getPeople();
        } else {
            long first = data.get(data.size()/2).getPeople();
            long second = data.get((data.size() - 1)/2).getPeople();

            median = ((float) (first + second) / 2);
        }
        int windows = officeRepository.findById(officeId)
                .orElseThrow(() -> new NotFoundException("There is no office with id = " + officeId))
                .getWindows();
        float queuePeople = Math.max(median - windows, 0);
        float shortQueuePeople = Math.max(queuePeople - windows, 0);
        float longQueuePeople = Math.max(queuePeople - shortQueuePeople, 0);
        float waitTime = (shortQueuePeople/2 + longQueuePeople) * averageUsedTime;

        prediction.setWaitTime(waitTime);
        predictionRepository.save(prediction);
    }
}
