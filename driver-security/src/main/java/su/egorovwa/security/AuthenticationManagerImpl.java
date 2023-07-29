package su.egorovwa.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;
import su.egorovwa.exception.UnauthorizedException;
import su.egorovwa.service.DriverService;

@Component
@RequiredArgsConstructor
public class AuthenticationManagerImpl implements AuthenticationManager {
    private final DriverService driverService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        DriverPrincipal driverPrincipal = (DriverPrincipal) authentication.getPrincipal();
        var driver = driverService.findByPhone(driverPrincipal.getName());
        return authentication;
    }
}
