package laz.dimboba.mapserver.user.controller;

import laz.dimboba.mapserver.user.UserAuthenticationService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@AllArgsConstructor
public class AuthController {
    private final UserAuthenticationService service;

    @PostMapping("/register")
    public ResponseEntity<RegistrationResponse> register (
        @RequestBody RegistrationRequest request
    ) {
        return ResponseEntity.ok(
            service.register(request)
        );
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login (
            @RequestBody AuthenticationRequest request
    ) {
        return ResponseEntity.ok(
            service.authenticate(request)
        );
    }
}
