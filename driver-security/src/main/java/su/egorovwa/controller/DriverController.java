package su.egorovwa.controller;

import jakarta.servlet.ServletException;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import su.egorovwa.dto.*;
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
    public AuthResponceDto login(@RequestBody AuthRequest authRequest) throws AuthException {
      TokenDetail tokenDetail = securityService.authenticate(authRequest.userName(), authRequest.password());
        return AuthResponceDto.create(AuthRespponce.builder()
                .driverId(tokenDetail.driverId())
                .expiresAt(tokenDetail.expiriesAt())
                .issuedAt(tokenDetail.issuedAt())
                .token(tokenDetail.token())
                .build());
    }
    @GetMapping("/drivers/{phone}")
    public DriverShortDto getDriver(@PathVariable("phone") String phone){
        return driverService.findByPhone(phone).orElse(DriverShortDto.builder().id(-1L).phone("a").build());
    }
}
