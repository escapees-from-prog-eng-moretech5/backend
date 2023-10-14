package laz.dimboba.mapserver.place;

import laz.dimboba.mapserver.exceptions.ForbiddenException;
import laz.dimboba.mapserver.place.controller.PlaceRegistrationRequest;
import laz.dimboba.mapserver.place.controller.PlaceRegistrationResponse;
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
    public PlaceRegistrationResponse register(PlaceRegistrationRequest request, String ip) {
        if(!isSecret(request.getPassword())) {
            throw new ForbiddenException("Wrong secret");
        }
        var place = Place.builder()
            .ip(ip)
            .build();

        return placeService.savePlace(place);
    }

    public boolean isSecret(String password) {
        return passwordEncoder.matches(password, secret);
    }
}
