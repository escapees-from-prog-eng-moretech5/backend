package laz.dimboba.mapserver.place.controller;

import laz.dimboba.mapserver.office.Office;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AddOfficesRequest implements Serializable {
    private String password;
    private List<Office> offices;
}
