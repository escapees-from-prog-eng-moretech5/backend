package laz.dimboba.mapserver.office.data;

import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.data.jpa.repository.JpaRepository;

@Hidden
public interface OfficeDataRepository extends JpaRepository<OfficeData, OfficeData.OfficeDataId> {
}
