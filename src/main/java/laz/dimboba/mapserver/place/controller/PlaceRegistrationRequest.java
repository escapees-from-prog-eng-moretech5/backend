package laz.dimboba.mapserver.place.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlaceRegistrationRequest implements Serializable {
    private String password;
}
