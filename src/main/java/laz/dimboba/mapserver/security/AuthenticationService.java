package laz.dimboba.mapserver.security;

import laz.dimboba.mapserver.security.controller.AuthenticationRequest;
import laz.dimboba.mapserver.security.controller.AuthenticationResponse;
import laz.dimboba.mapserver.security.controller.RegistrationRequest;
import laz.dimboba.mapserver.security.controller.RegistrationResponse;
import laz.dimboba.mapserver.user.User;
import laz.dimboba.mapserver.user.UserDTO;
import laz.dimboba.mapserver.user.UserService;
import lombok.AllArgsConstructor;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthenticationService {
    private final UserService userService;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getNumber(),
                        request.getPassword()
                )
        );
        var user = userService.loadUserByUsername(request.getNumber());
        var token = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(token)
                .build();
    }

    public RegistrationResponse register(RegistrationRequest request) {
        var user = User.builder()
                .number(request.getNumber())
                .password(passwordEncoder.encode(request.getPassword()))
//                .addressLatitude(request.getAddressLatitude())
//                .addressLongitude(request.getAddressLongitude())
                .name(request.getName())
                .build();
        var savedUser = userService.saveUser(user);
        var jwtToken = jwtService.generateToken(user);

        return RegistrationResponse.builder()
                .token(jwtToken)
                .user(new UserDTO(savedUser))
                .build();
    }

}
