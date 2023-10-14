package laz.dimboba.mapserver.atm.data;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "atms_data")
@IdClass(AtmData.AtmDataId.class)
public class AtmData implements Serializable {
    @Id
    @Column(name = "time")
    private Timestamp time;

    @Id
    @Column(name = "atm_id")
    private UUID atmId;

    @Column(name = "people")
    private int people;

    @AllArgsConstructor
    @Data
    static class AtmDataId implements Serializable {
        private UUID atmId;
        private Timestamp time;
    }
}
