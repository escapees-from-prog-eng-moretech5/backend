package laz.dimboba.mapserver.office.data;

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
@Table(name = "offices_data")
@IdClass(OfficeData.OfficeDataId.class)
public class OfficeData implements Serializable {
    @Id
    @Column(name = "time")
    private Timestamp time;

    @Id
    @Column(name = "office_id")
    private UUID officeId;

    @Column(name = "people")
    private int people;

    @AllArgsConstructor
    @Data
    static class OfficeDataId implements Serializable {
        private UUID officeId;
        private Timestamp time;
    }
}
