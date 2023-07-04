package su.egorovwa.service;

import su.egorovwa.dto.NewDriverDto;
import su.egorovwa.exception.RegistrationException;

public interface DriverService {
    NewDriverDto registerDriver(NewDriverDto newDriverDto) throws RegistrationException;

}
