package laz.dimboba.mapserver.place;

import laz.dimboba.mapserver.exceptions.ForbiddenException;
import laz.dimboba.mapserver.place.controller.RegistrationRequest;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;

@AllArgsConstructor
@Service
public class PlaceAuthenticationService {

    @Value("${place.registration-secret}")
    private final String secret;
    private final PasswordEncoder passwordEncoder;
    private final PlaceService placeService;
    public void register(RegistrationRequest request, String ip) {
        if(Objects.equals(passwordEncoder.encode(request.getPassword()), secret)) {
            throw new ForbiddenException("Wrong secret");
        }
        var place = Place.builder()
            .id(request.getId())
            .type(request.getType())
            .windows(request.getWindows())
            .ip(ip)
            .build();
        placeService.savePlace(place);
    }
}
