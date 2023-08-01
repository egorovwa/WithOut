package su.egorovwa.driver;

import su.egorovwa.dto.driver.DriverShortDto;
import su.egorovwa.dto.driver.NewDriverDto;
import su.egorovwa.exception.ObjectAlredyExistException;
import su.egorovwa.exception.ObjectNotFoundException;
import su.egorovwa.model.Driver;

public interface DriverService {
    NewDriverDto registerDriver(NewDriverDto newDriverDto) throws ObjectAlredyExistException;

    DriverShortDto findByPhone(String phone) throws  ObjectNotFoundException;
    Driver findById(Long id) throws ObjectNotFoundException;
}
