package laz.dimboba.mapserver.security.controller;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationRequest implements Serializable {
    private String number;
    private String password;

    private String name;
    private double addressLatitude;
    private double addressLongitude;

}
