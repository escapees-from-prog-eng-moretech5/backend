package laz.dimboba.mapserver.place;

import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

@Hidden
public interface PlaceRepository extends JpaRepository<Place, UUID> {
    Optional<Place> findByIp (String ip);
}
