package laz.dimboba.mapserver.prediction;


import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/api/v1/prediction")
@AllArgsConstructor
@SecurityRequirement(name = "Bearer")
public class PredictionController {
    private final PredictionRepository repository;
    @GetMapping
    public ResponseEntity<List<Prediction>> getAllPredictions() {
        return ResponseEntity.ok(
                repository.findAll()
        );
    }
}
