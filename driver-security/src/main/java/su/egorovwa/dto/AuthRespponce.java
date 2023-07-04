package su.egorovwa.dto;

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
