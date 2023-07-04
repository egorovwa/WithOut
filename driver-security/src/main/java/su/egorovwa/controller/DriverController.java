package su.egorovwa.controller;

import jakarta.servlet.ServletException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import su.egorovwa.dto.AuthRequest;
import su.egorovwa.dto.AuthRespponce;
import su.egorovwa.dto.NewDriverDto;
import su.egorovwa.exception.AuthException;
import su.egorovwa.security.SecurityService;
import su.egorovwa.security.TokenDetail;
import su.egorovwa.service.DriverService;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class DriverController {
    private final DriverService driverService;
    private final SecurityService securityService;

    @PostMapping("/auth/registre")
    public NewDriverDto registre(@RequestBody NewDriverDto newDriverDto) throws ServletException, IOException {
        return driverService.registre(newDriverDto);
    }

    @PostMapping("/auth/login")
    public AuthRespponce login(@RequestBody AuthRequest authRequest) throws AuthException {
      TokenDetail tokenDetail = securityService.authenticate(authRequest.userName(), authRequest.password());
        return AuthRespponce.builder()
                .driverId(tokenDetail.driverId())
                .expiresAt(tokenDetail.expiriesAt())
                .issuedAt(tokenDetail.issuedAt())
                .token(tokenDetail.token())
                .build();
    }
}
