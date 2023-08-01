package su.egorovwa.dto.driver;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.Builder;

import java.util.Date;

@Builder(toBuilder = true)
public record AuthRespponce(
        Long driverId,
        String token,
        Date issuedAt,
        Date expiresAt
) {
}
