package laz.dimboba.mapserver.office.data;

import jakarta.persistence.*;
import laz.dimboba.mapserver.utils.DayOfTheWeek;
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
public class OfficeData implements Serializable, Comparable<OfficeData> {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "time")
    private int time;

    @Column(name = "day")
    private DayOfTheWeek day;

    @Column(name = "office_id")
    private UUID officeId;

    @Column(name = "people")
    private int people;

    @Override
    public boolean equals(Object obj) {
        return ((OfficeData) obj).getId().equals(getId());
    }

    @Override
    public int compareTo(OfficeData o) {
        return people - o.people;
    }
}
