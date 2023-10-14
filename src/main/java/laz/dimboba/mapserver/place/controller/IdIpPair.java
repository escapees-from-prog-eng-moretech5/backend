package laz.dimboba.mapserver.place.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class IdIpPair {
    private UUID officeId;
    private String cameraIp;
}
