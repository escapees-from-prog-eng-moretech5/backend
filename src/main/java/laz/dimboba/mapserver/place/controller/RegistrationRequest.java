package laz.dimboba.mapserver.place.controller;

import laz.dimboba.mapserver.place.Type;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationRequest implements Serializable {
    private UUID id;
    private String password;
    private int windows;
    private Type type;
}
