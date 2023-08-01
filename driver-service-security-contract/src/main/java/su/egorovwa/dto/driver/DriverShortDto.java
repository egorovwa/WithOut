package su.egorovwa.dto.driver;

import lombok.Builder;

@Builder(toBuilder = true)
public record DriverShortDto(
        Long id,
        String phone,
        String password
) {
}
