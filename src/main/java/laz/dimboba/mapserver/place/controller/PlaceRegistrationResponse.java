package laz.dimboba.mapserver.place.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlaceRegistrationResponse implements Serializable {
    private UUID id;
    private List<IdIpPair> cameras;
}
