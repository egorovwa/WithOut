package su.egorovwa.driver;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import su.egorovwa.dto.driver.DriverShortDto;
import su.egorovwa.dto.driver.NewDriverDto;
import su.egorovwa.dto.mapers.DriverDtoMaper;
import su.egorovwa.exception.ObjectAlredyExistException;
import su.egorovwa.exception.ObjectNotFoundException;
import su.egorovwa.model.Driver;
import su.egorovwa.repository.DriverRepository;

@Service
@RequiredArgsConstructor
@Slf4j
public class DriverServiceImpl implements DriverService {
    private final DriverRepository driverRepository;
    private final DriverDtoMaper driverDtoMaper;
    @Override
    public NewDriverDto registerDriver(NewDriverDto newDriverDto) throws ObjectAlredyExistException {
      log.info("Регистрация водителя {} ", newDriverDto);
      try {
          return driverDtoMaper.toNewDto(driverRepository.save(driverDtoMaper.fromNewDto(newDriverDto)));
      }catch (DataIntegrityViolationException e){
          log.warn("Ошибка регистрации: {}", e.getClass());
          throw new ObjectAlredyExistException("Driver alredy exist.");
      }
    }

    @Override
    public DriverShortDto findByPhone(String phone) throws ObjectNotFoundException {
        log.debug("Find driver by phone {}", phone);
        return driverRepository.findByPhone(phone)
                .map(driverDtoMaper::toShortDto)
                .orElseThrow(()-> new ObjectNotFoundException("Driver not found"));
    }

    @Override
    public Driver findById(Long id) throws ObjectNotFoundException {
        return driverRepository.findById(id)
                .orElseThrow(()->  new ObjectNotFoundException("Driver not found"));
    }
}
