package laz.dimboba.mapserver.place;

import laz.dimboba.mapserver.exceptions.ConflictException;
import laz.dimboba.mapserver.exceptions.ForbiddenException;
import laz.dimboba.mapserver.exceptions.NotFoundException;
import laz.dimboba.mapserver.exceptions.PlaceNotFoundException;
import laz.dimboba.mapserver.place.controller.DataRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.UUID;

@Service
@AllArgsConstructor
public class PlaceService {
    private final PlaceRepository repository;

    public void savePlace(Place place) {
        if(repository.existsById(place.getId())) {
            throw new ConflictException("There is place with id = " + place.getId());
        }
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
        place.setCurrent(request.getCurrent());
        repository.save(place);
    }
}
