package laz.dimboba.mapserver.security.controller;

import com.fasterxml.jackson.annotation.JsonProperty;
import laz.dimboba.mapserver.user.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegistrationResponse implements Serializable {
    @JsonProperty("user")
    private UserDTO user;
    private String token;
}
