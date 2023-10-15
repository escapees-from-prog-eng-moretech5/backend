package laz.dimboba.mapserver.place;

import laz.dimboba.mapserver.exceptions.ForbiddenException;
import laz.dimboba.mapserver.exceptions.NotFoundException;
import laz.dimboba.mapserver.office.OfficeRepository;
import laz.dimboba.mapserver.office.data.OfficeData;
import laz.dimboba.mapserver.office.data.OfficeDataRepository;
import laz.dimboba.mapserver.place.controller.DataRequest;
import laz.dimboba.mapserver.place.controller.IdIpPair;
import laz.dimboba.mapserver.place.controller.PlaceRegistrationResponse;
import laz.dimboba.mapserver.prediction.PredictionService;
import laz.dimboba.mapserver.utils.DayOfTheWeek;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

@Service
@AllArgsConstructor
public class PlaceService {
    private final PlaceRepository repository;
    private final OfficeDataRepository officeDataRepository;
    private final OfficeRepository officeRepository;
    private final PredictionService predictionService;
    private final Calendar calendar = Calendar.getInstance();

    public PlaceRegistrationResponse savePlace(Place place) {
        repository.save(place);

        var list = officeRepository.findAll()
            .stream()
            .map(office -> new IdIpPair(office.getId(), office.getCameraIp()))
            .toList();

        return new PlaceRegistrationResponse(
                place.getId(),
                list
        );
    }

    public void updateData(DataRequest request, String ip) {
        var place = repository.findById(request.getId())
                .orElseThrow(() -> new NotFoundException("There is no place with id = " + request.getId()));
        if(!Objects.equals(place.getIp(), ip)) {
            throw new ForbiddenException("Your ip has changed");
        }

        var localeDateTime = request.getTime().toLocalDateTime();
        int minInHour = localeDateTime.getMinute();
        int hoursInMins = localeDateTime.getHour() * 60;
        int predictionTime = (int) (Math.round(((double) (minInHour + hoursInMins))/30) * 30);

        calendar.setTimeInMillis(request.getTime().getTime());
        DayOfTheWeek day = DayOfTheWeek.values()[calendar.get(Calendar.DAY_OF_WEEK)];

        officeDataRepository.save(
            OfficeData.builder()
                .people(request.getCurrent())
                .time(predictionTime)
                .day(day)
                .officeId(request.getOfficeId())
                .build()
        );

        predictionService.updatePrediction(
                request.getOfficeId(),
                predictionTime,
                day
        );
    }
}
