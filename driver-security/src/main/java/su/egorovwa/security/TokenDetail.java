package su.egorovwa.security;

import lombok.Builder;

import java.util.Date;
@Builder(toBuilder = true)
public record TokenDetail(
        Long driverId,
        String token,
        Date issuedAt,
        Date expiriesAt
) {
}
