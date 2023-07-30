package su.egorovwa.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;
import su.egorovwa.dto.DriverShortDto;
import su.egorovwa.dto.NewDriverDto;
import su.egorovwa.dto.mapers.DriverDtoMaper;
import su.egorovwa.exception.DriverNotFoundException;
import su.egorovwa.exception.ObjectAlredyExistException;
import su.egorovwa.exception.ObjectNotFoundException;
import su.egorovwa.exception.RegistrationException;
import su.egorovwa.repository.DriverRepository;
import su.egorovwa.service.DriverService;
@Service
@RequiredArgsConstructor
@Slf4j
public class DriverServiceImpl implements DriverService {
    private final DriverRepository driverRepository;
    private final DriverDtoMaper driverDtoMaper;
    @Override
    @Transactional
    public NewDriverDto registerDriver(NewDriverDto newDriverDto) throws ObjectAlredyExistException {
      log.info("Регистрация водителя {} ", newDriverDto);
      try {
          return driverDtoMaper.toNewDto(driverRepository.save(driverDtoMaper.fromNewDto(newDriverDto)));
      }catch (Exception e){
          log.warn("Ошибка регистрации: {}", e.getMessage());
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
}
