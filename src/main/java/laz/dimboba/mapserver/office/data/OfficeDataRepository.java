package laz.dimboba.mapserver.office.data;

import io.swagger.v3.oas.annotations.Hidden;
import laz.dimboba.mapserver.utils.DayOfTheWeek;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

@Hidden
public interface OfficeDataRepository extends JpaRepository<OfficeData, UUID> {
    List<OfficeData> findAllByOfficeIdAndTimeAndDay (UUID officeId, long time, DayOfTheWeek day);
}
