package laz.dimboba.mapserver.prediction;

import io.swagger.v3.oas.annotations.Hidden;
import laz.dimboba.mapserver.utils.DayOfTheWeek;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

@Hidden
public interface PredictionRepository extends JpaRepository<Prediction, UUID> {
    Optional<Prediction> findByOfficeIdAndTimeAndDay (UUID officeId, long time, DayOfTheWeek day);
}
