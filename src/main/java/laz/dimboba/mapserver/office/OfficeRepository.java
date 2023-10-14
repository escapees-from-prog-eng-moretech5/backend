package laz.dimboba.mapserver.office;

import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

@Hidden
public interface OfficeRepository extends JpaRepository<Office, UUID> {
}
