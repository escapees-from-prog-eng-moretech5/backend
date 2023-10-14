package laz.dimboba.mapserver.place;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "places")
public class Place implements Serializable {
    @Column(name = "id")
    private UUID id;

    @Column(name = "type")
    @Enumerated(value = EnumType.STRING)
    private Type type;

    @Id
    @Column(name = "ip")
    private String ip;

    @Column(name = "windows")
    private int windows;

}
