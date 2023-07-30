package su.egorovwa.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import su.egorovwa.dto.DriverShortDto;
import su.egorovwa.dto.NewDriverDto;
import su.egorovwa.exception.ObjectAlredyExistException;
import su.egorovwa.exception.ObjectNotFoundException;
import su.egorovwa.service.DriverService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/driver")
public class DriverController {
    private final DriverService driverService;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public NewDriverDto registerDriver(@RequestBody NewDriverDto newDriverDto) throws ObjectAlredyExistException {
        return driverService.registerDriver(newDriverDto);
    }

    @GetMapping("/{phone}")
    public DriverShortDto findDriverByPhone(@PathVariable("phone") String phone) throws ObjectNotFoundException {
        return driverService.findByPhone(phone);
    }
}
