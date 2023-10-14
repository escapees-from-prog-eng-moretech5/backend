package laz.dimboba.mapserver.office;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

@NoArgsConstructor
@Data
@AllArgsConstructor
@Builder
@Entity
@Table(name = "office_open_hours_individual")
public class OfficeHoursIndividual {
    @Id
    @Column(name = "office_id")
    private UUID officeId;

    @Id
    @Column(name = "day")
    @Enumerated(value = EnumType.ORDINAL)
    private DayOfTheWeek day;

    @Column(name = "open")
    private int open;

    @Column(name = "close")
    private int close;

    @AllArgsConstructor
    @Data
    static class OfficeHoursIndividualID implements Serializable {
        private UUID officeId;
        private int day;
    }
}
