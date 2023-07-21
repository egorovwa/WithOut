package su.egorovwa.dto;

import lombok.Builder;

@Builder(toBuilder = true)
public record DriverShortDto(
        Long id,
        String phone,
        String password
) {
}
