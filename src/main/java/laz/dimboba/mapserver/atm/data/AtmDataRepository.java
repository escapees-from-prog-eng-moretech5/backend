package laz.dimboba.mapserver.atm.data;

import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

@Hidden
public interface AtmDataRepository extends JpaRepository<AtmData, UUID> {
}
