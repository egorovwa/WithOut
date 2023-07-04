package su.egorovwa.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import su.egorovwa.client.Client;
import su.egorovwa.dto.DriverShortDto;
import su.egorovwa.exception.AuthException;
import su.egorovwa.service.DriverService;

import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class SecurityService {
    private final BCryptPasswordEncoder passwordEncoder;
    private final DriverService driverService;
    @Value("${security.expirationInMillis}")
    private Long expirationInMillis;
    @Value("${security.secret}")
    private String secret;

    public TokenDetail authenticate(String phone, String password) throws AuthException {
        DriverShortDto driverShortDto = driverService.findByPhone(phone)
                .orElseThrow(() -> new AuthException("driver not found"));
        if (!passwordEncoder.encode(password).equals(password)) {
            throw new AuthException("Incorrect password");
        }
        Date issuetAt = new Date();
        Date expiriesAt = new Date(issuetAt.getTime() + expirationInMillis);
        return TokenDetail.builder()
                .driverId(driverShortDto.id())
                .expiriesAt(expiriesAt)
                .issuedAt(issuetAt)
                .token(generateToken(driverShortDto, issuetAt, expiriesAt))
                .build();
    }

    private String generateToken(DriverShortDto driverShortDto, Date issuetAt, Date expiriesAt) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("role", "DRIVER");
        claims.put("driverPhone", driverShortDto.phone());
        String subject = driverShortDto.id().toString();
        return Jwts.builder()
                .setSubject(subject)
                .addClaims(claims)
                .setIssuedAt(issuetAt)
                .setExpiration(expiriesAt)
                .signWith(SignatureAlgorithm.ES256, Base64.getEncoder().encode(secret.getBytes()))
                .compact();
    }
}
