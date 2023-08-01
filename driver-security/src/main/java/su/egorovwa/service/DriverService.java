package su.egorovwa.service;

import jakarta.servlet.ServletException;
import su.egorovwa.dto.driver.DriverShortDto;
import su.egorovwa.dto.driver.NewDriverDto;
import su.egorovwa.exception.ServerGetvayClientException;

import java.io.IOException;
import java.util.Optional;

public interface DriverService {
    NewDriverDto registre(NewDriverDto newDriverDto) throws ServletException, IOException, ServerGetvayClientException;

    Optional<DriverShortDto> findByPhone(String name);
}
