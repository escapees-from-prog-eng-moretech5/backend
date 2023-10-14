package laz.dimboba.mapserver.place.controller;


import jakarta.servlet.http.HttpServletRequest;
import laz.dimboba.mapserver.atm.AtmRepository;
import laz.dimboba.mapserver.exceptions.ForbiddenException;
import laz.dimboba.mapserver.office.OfficeRepository;
import laz.dimboba.mapserver.place.PlaceAuthenticationService;
import laz.dimboba.mapserver.place.PlaceService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/place")
@AllArgsConstructor
public class PlaceController {
    private final PlaceAuthenticationService authenticationService;
    private final PlaceService placeService;
    private final OfficeRepository officeRepository;
    private final AtmRepository atmRepository;

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
        placeService.updatePlace(request, http.getRemoteAddr());
        return ResponseEntity.ok("Success");
    }

}
