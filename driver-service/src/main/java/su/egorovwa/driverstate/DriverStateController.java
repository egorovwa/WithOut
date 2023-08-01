package su.egorovwa.driverstate;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import su.egorovwa.dto.state.DriverStateRequest;
import su.egorovwa.dto.state.DriverStateResponce;
import su.egorovwa.exception.ServerDataException;

@RestController
@RequiredArgsConstructor
public class DriverStateController {
    private final DriverStateService stateService;
    @PostMapping("/state/{id}")
    public DriverStateResponce getDriverState(
            @PathVariable("id") String driverId,
            @RequestBody DriverStateRequest request
    ) throws ServerDataException {
       return stateService.proccesState(driverId, request);
    }
}
