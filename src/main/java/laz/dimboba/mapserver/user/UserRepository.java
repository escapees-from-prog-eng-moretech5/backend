package laz.dimboba.mapserver.user;

import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;


@Hidden
public interface UserRepository extends JpaRepository<User, UUID> {
    Optional<User> findUserByNumber(String number);
}
