package su.egorovwa.controller;

import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import su.egorovwa.dto.DriverShortDto;
import su.egorovwa.dto.NewDriverDto;
import su.egorovwa.exception.DriverNotFoundException;
import su.egorovwa.exception.RegistrationException;
import su.egorovwa.service.DriverService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/driver")
public class DriverController {
    private final DriverService driverService;
    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public NewDriverDto registerDriver(@RequestBody NewDriverDto newDriverDto) throws RegistrationException {
        return driverService.registerDriver(newDriverDto);
    }
    @GetMapping("/{phone}")
    public DriverShortDto findDriverByPhone(@PathVariable("phone") String phone) throws DriverNotFoundException {
       return driverService.findByPhone(phone);
    }
}
