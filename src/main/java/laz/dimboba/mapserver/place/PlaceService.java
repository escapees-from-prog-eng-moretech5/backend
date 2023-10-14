package laz.dimboba.mapserver.place;

import laz.dimboba.mapserver.atm.data.AtmData;
import laz.dimboba.mapserver.atm.data.AtmDataRepository;
import laz.dimboba.mapserver.exceptions.ForbiddenException;
import laz.dimboba.mapserver.exceptions.NotFoundException;
import laz.dimboba.mapserver.exceptions.PlaceNotFoundException;
import laz.dimboba.mapserver.office.OfficeRepository;
import laz.dimboba.mapserver.office.data.OfficeData;
import laz.dimboba.mapserver.office.data.OfficeDataRepository;
import laz.dimboba.mapserver.place.controller.DataRequest;
import laz.dimboba.mapserver.place.controller.IdIpPair;
import laz.dimboba.mapserver.place.controller.PlaceRegistrationResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
@AllArgsConstructor
public class PlaceService {
    private final PlaceRepository repository;
    private final OfficeDataRepository officeDataRepository;
    private final OfficeRepository officeRepository;

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

    public void updatePlace(DataRequest request, String ip) {
        var place = repository.findById(request.getId())
                .orElseThrow(() -> new NotFoundException("There is no place with id = " + request.getId()));
        if(!Objects.equals(place.getIp(), ip)) {
            throw new ForbiddenException("Your ip has changed");
        }

        officeDataRepository.save(
            OfficeData.builder()
                .people(request.getCurrent())
                .time(request.getTime())
                .officeId(request.getOfficeId())
                .build()
        );


        repository.save(place);
    }
}
