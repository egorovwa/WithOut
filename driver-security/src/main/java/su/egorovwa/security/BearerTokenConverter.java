package su.egorovwa.security;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationConverter;
import su.egorovwa.exception.AuthException;
import su.egorovwa.exception.UnauthorizedException;

import java.util.List;

@RequiredArgsConstructor
public class BearerTokenConverter implements AuthenticationConverter {
    private final JwtHendle jwtHendle;
    private static final String BEARER_PREFIX = "Bearer ";

    private String getBearerValue(String bearearHeader) {
        return bearearHeader.substring(BEARER_PREFIX.length());
    }

    @Override
    public Authentication convert(HttpServletRequest request) {
        try {
            String token = getBearerValue(request.getHeaders(HttpHeaders.AUTHORIZATION).nextElement());

            JwtHendle.VertificationResult vertificationResult = jwtHendle.check(token);
            String phone = (String) vertificationResult.claims.get("driverPhone");
            String role = (String) vertificationResult.claims.get("role");
            Long id = Long.parseLong(vertificationResult.claims.getSubject());
            DriverPrincipal driverPrincipal = new DriverPrincipal(id, phone);
            List<SimpleGrantedAuthority> simpleGrantedAuthorityList = List.of(new SimpleGrantedAuthority(role));
            return new UsernamePasswordAuthenticationToken(driverPrincipal, null, simpleGrantedAuthorityList);
        } catch (AuthException | NullPointerException e) {
            throw new UnauthorizedException(e.getMessage());
        }
    }
}
