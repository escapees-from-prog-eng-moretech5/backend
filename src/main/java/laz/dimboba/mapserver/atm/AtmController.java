package laz.dimboba.mapserver.atm;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/atm")
@AllArgsConstructor
@SecurityRequirement(name = "Bearer")
public class AtmController {
    private final AtmRepository repository;
    @GetMapping
    public ResponseEntity<List<Atm>> getAllAtms() {
        return ResponseEntity.ok(
                repository.findAll()
        );
    }
}
