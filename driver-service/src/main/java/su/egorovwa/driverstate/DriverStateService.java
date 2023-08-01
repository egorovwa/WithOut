package su.egorovwa.driverstate;

import su.egorovwa.dto.state.DriverStateRequest;
import su.egorovwa.dto.state.DriverStateResponce;
import su.egorovwa.exception.ServerDataException;

public interface DriverStateService {
    DriverStateResponce proccesState(String driverId, DriverStateRequest request) throws ServerDataException;
}
