package laz.dimboba.mapserver.place.controller;

import laz.dimboba.mapserver.place.Type;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DataRequest implements Serializable {
    private UUID id;
    private Type type;
    private int current;
    private Timestamp time;
}
