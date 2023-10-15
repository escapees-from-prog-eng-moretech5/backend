package laz.dimboba.mapserver.prediction;

import jakarta.persistence.*;
import laz.dimboba.mapserver.utils.DayOfTheWeek;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "predictions")
public class Prediction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "office_id")
    private UUID officeId;

    @Column(name = "time")
    private int time;

    @Column(name = "day")
    @Enumerated(EnumType.ORDINAL)
    private DayOfTheWeek day;

    @Column(name = "wait_time")
    private float waitTime;
}
