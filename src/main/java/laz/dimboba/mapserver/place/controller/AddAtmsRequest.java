package laz.dimboba.mapserver.place.controller;

import laz.dimboba.mapserver.atm.Atm;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class AddAtmsRequest implements Serializable {
    private String password;
    private List<Atm> atms;
}
