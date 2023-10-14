package laz.dimboba.mapserver.place.controller;


import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.servlet.http.HttpServletRequest;
import laz.dimboba.mapserver.place.PlaceAuthenticationService;
import laz.dimboba.mapserver.place.PlaceService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/place")
@AllArgsConstructor
@SecurityRequirement(name = "Bearer")
public class PlaceController {
    private final PlaceAuthenticationService authenticationService;
    private final PlaceService placeService;

    @PostMapping("/register")
    public ResponseEntity<String> register (
            @RequestBody RegistrationRequest request,
            HttpServletRequest http
    ) {
        authenticationService.register(request, http.getRemoteAddr());
        return ResponseEntity.ok("Success");
    }

    @PostMapping
    public ResponseEntity<String> getData (
            @RequestBody DataRequest request,
            HttpServletRequest http
    ) {
        placeService.updatePlace(request, http.getRemoteAddr());
        return ResponseEntity.ok("Success");
    }

}
