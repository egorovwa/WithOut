package su.egorovwa.dto.mapers;

import org.springframework.stereotype.Component;
import su.egorovwa.dto.NewDriverDto;
import su.egorovwa.model.Driver;

@Component
public class DriverDtoMaper {
    public Driver fromNewDto(NewDriverDto newDriverDto) {
        return Driver.builder()
                .phone(newDriverDto.phone())
                .fistName(newDriverDto.fistName())
                .lastName(newDriverDto.lastName())
                .password(newDriverDto.password())
                .email(newDriverDto.email())
                .build();
    }

    public NewDriverDto toNewDto(Driver driver) {
        return new NewDriverDto(driver.getId(), driver.getPhone(), driver.getFistName(), driver.getLastName(), driver.getPassword(), driver.getEmail());
    }
}
