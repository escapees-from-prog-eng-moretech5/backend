package laz.dimboba.mapserver.office;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import laz.dimboba.mapserver.utils.DayOfTheWeek;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@NoArgsConstructor
@Data
@AllArgsConstructor
@Builder
@Entity
@Table(name = "office_open_hours_individual")
public class OfficeHoursIndividual {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "office_id")
    @JsonIgnore
    private Office office;

    @Column(name = "day")
    @Enumerated(value = EnumType.ORDINAL)
    private DayOfTheWeek day;

    @Column(name = "open")
    private int open;

    @Column(name = "close")
    private int close;
}
