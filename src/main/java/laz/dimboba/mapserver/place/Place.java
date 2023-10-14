package laz.dimboba.mapserver.place;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "places")
public class Place {
    @Id
    private UUID id;

    @Column(name = "type")
    @Enumerated(value = EnumType.STRING)
    private Type type;

    @Column(name = "ip")
    private String ip;

    @Column(name = "windows")
    private int windows;

    @Column(name = "current")
    private int current;
}
