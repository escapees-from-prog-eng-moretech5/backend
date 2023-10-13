package laz.dimboba.mapserver.atm;

import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

@Hidden
public interface AtmRepository extends JpaRepository<Atm, UUID> {
}
