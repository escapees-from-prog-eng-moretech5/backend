package laz.dimboba.mapserver.place.controller;


import jakarta.servlet.http.HttpServletRequest;
import laz.dimboba.mapserver.atm.AtmRepository;
import laz.dimboba.mapserver.exceptions.ForbiddenException;
import laz.dimboba.mapserver.office.OfficeRepository;
import laz.dimboba.mapserver.office.data.OfficeDataRepository;
import laz.dimboba.mapserver.place.PlaceAuthenticationService;
import laz.dimboba.mapserver.place.PlaceService;
import laz.dimboba.mapserver.prediction.PredictionService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@RequestMapping("/api/v1/place")
@AllArgsConstructor
public class PlaceController {
    private final PlaceAuthenticationService authenticationService;
    private final PlaceService placeService;
    private final OfficeRepository officeRepository;
    private final AtmRepository atmRepository;
    private final OfficeDataRepository officeDataRepository;
    private final PredictionService predictionService;

    @PostMapping("/offices")
    public ResponseEntity<String> addOffices (
            @RequestBody AddOfficesRequest request
    ) {
        System.out.println(request.toString());
        if(!authenticationService.isSecret(request.getPassword())) {
            throw new ForbiddenException("Wrong password");
        }
        request.getOffices().forEach(
                office -> {
                    office.getOpenHours().forEach(
                            openHours -> {
                                openHours.setOffice(office);
                            }
                    );
                    office.getOpenHoursIndividual().forEach(
                            openHours -> {
                                openHours.setOffice(office);
                            }
                    );
                }
        );
        officeRepository.saveAll(request.getOffices());
        return ResponseEntity.ok("Success");
    }

    @PostMapping("/atms")
    public ResponseEntity<String> addAtms (
            @RequestBody AddAtmsRequest request
    ) {
        if(!authenticationService.isSecret(request.getPassword())) {
            throw new ForbiddenException("Wrong password");
        }
        request.getAtms().forEach(
            atm -> {
                atm.getServices().forEach(
                    atmServiceData -> {
                        atmServiceData.setAtm(atm);
                    }
                );
            }
        );
        atmRepository.saveAll(request.getAtms());
        return ResponseEntity.ok("Success");
    }

    @PostMapping("/predictions")
    public ResponseEntity<String> addPredictions (
            @RequestBody AddPredictionsRequest request
    ) {
        if(!authenticationService.isSecret(request.getPassword())) {
            throw new ForbiddenException("Wrong password");
        }

        Random random = new Random();
        var offices = officeRepository.findAll();
        offices.forEach(office -> {
            if(office.getWindows() < 8) {
                office.setWindows(
                        random.nextInt(8, 13)
                );
            }
        });

        request.getOfficeData()
            .forEach( officeData -> {
                int i = random.nextInt(offices.size());
                if(officeData.getOfficeId() == null) {
                    officeData.setOfficeId(offices.get(i).getId());
                }
                officeDataRepository.save(officeData);
                predictionService.updatePrediction(
                        officeData.getOfficeId(),
                        officeData.getTime(),
                        officeData.getDay()
                );
            });

        return ResponseEntity.ok("Success");
    }

    @PostMapping("/register")
    public ResponseEntity<PlaceRegistrationResponse> register (
            @RequestBody PlaceRegistrationRequest request,
            HttpServletRequest http
    ) {
        return ResponseEntity.ok(
                authenticationService.register(request, http.getRemoteAddr())
        );
    }

    @PostMapping
    public ResponseEntity<String> getData (
            @RequestBody DataRequest request,
            HttpServletRequest http
    ) {
        placeService.updateData(request, http.getRemoteAddr());
        return ResponseEntity.ok("Success");
    }

}
