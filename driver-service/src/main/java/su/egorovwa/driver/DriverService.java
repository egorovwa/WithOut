package su.egorovwa.driver;

import su.egorovwa.dto.DriverShortDto;
import su.egorovwa.dto.NewDriverDto;
import su.egorovwa.exception.DriverNotFoundException;
import su.egorovwa.exception.ObjectAlredyExistException;
import su.egorovwa.exception.ObjectNotFoundException;
import su.egorovwa.exception.RegistrationException;

public interface DriverService {
    NewDriverDto registerDriver(NewDriverDto newDriverDto) throws ObjectAlredyExistException;

    DriverShortDto findByPhone(String phone) throws  ObjectNotFoundException;
}
