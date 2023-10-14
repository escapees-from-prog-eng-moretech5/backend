package laz.dimboba.mapserver.office.data;

import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

@Hidden
public interface OfficeDataRepository extends JpaRepository<OfficeData, UUID> {
}
