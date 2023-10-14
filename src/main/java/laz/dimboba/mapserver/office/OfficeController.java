package laz.dimboba.mapserver.office;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/office")
@AllArgsConstructor
@SecurityRequirement(name = "Bearer")
public class OfficeController {
    private final OfficeRepository repository;
    @GetMapping
    public ResponseEntity<List<Office>> getAllOffices() {
        return ResponseEntity.ok(
                repository.findAll()
        );
    }
}
