package su.egorovwa.service;

import jakarta.servlet.ServletException;
import su.egorovwa.dto.DriverShortDto;
import su.egorovwa.dto.NewDriverDto;

import java.io.IOException;
import java.util.Optional;

public interface DriverService {
    NewDriverDto registre(NewDriverDto newDriverDto) throws ServletException, IOException;

    Optional<DriverShortDto> findByPhone(String name);
}
