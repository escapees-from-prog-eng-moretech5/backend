package laz.dimboba.mapserver.place;

import laz.dimboba.mapserver.atm.data.AtmData;
import laz.dimboba.mapserver.atm.data.AtmDataRepository;
import laz.dimboba.mapserver.exceptions.ForbiddenException;
import laz.dimboba.mapserver.exceptions.NotFoundException;
import laz.dimboba.mapserver.exceptions.PlaceNotFoundException;
import laz.dimboba.mapserver.office.data.OfficeData;
import laz.dimboba.mapserver.office.data.OfficeDataRepository;
import laz.dimboba.mapserver.place.controller.DataRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.UUID;

@Service
@AllArgsConstructor
public class PlaceService {
    private final PlaceRepository repository;
    private final OfficeDataRepository officeDataRepository;
    private final AtmDataRepository atmDataRepository;

    public void savePlace(Place place) {
        repository.save(place);
    }

    public Place getPlace(UUID id, Type type) throws PlaceNotFoundException{
        return repository.findByIdAndType(id, type)
                .orElseThrow(() -> new PlaceNotFoundException());
    }

    public void updatePlace(DataRequest request, String ip) {
        var place = repository.findByIdAndType(request.getId(), request.getType())
                .orElseThrow(() -> new NotFoundException("There is no place with id = " + request.getId()));
        if(!Objects.equals(place.getIp(), ip)) {
            throw new ForbiddenException("Your ip has changed");
        }
        switch (request.getType()) {
            case ATM -> atmDataRepository.save(
                    AtmData.builder()
                        .people(request.getCurrent())
                        .time(request.getTime())
                        .atmId(request.getId())
                        .build()
            );
            case OFFICE -> officeDataRepository.save(
                    OfficeData.builder()
                        .people(request.getCurrent())
                        .time(request.getTime())
                        .officeId(request.getId())
                        .build()
            );
        }

        repository.save(place);
    }
}
