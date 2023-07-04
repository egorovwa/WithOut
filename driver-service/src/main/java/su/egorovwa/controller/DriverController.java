package su.egorovwa.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import su.egorovwa.dto.NewDriverDto;
import su.egorovwa.exception.RegistrationException;
import su.egorovwa.service.DriverService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/driver")
public class DriverController {
    private final DriverService driverService;
    @PostMapping("/register")
    public NewDriverDto registerDriver(@RequestBody NewDriverDto newDriverDto) throws RegistrationException {
        return driverService.registerDriver(newDriverDto);
    }
}
