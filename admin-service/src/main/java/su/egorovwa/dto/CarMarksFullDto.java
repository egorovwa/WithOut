package su.egorovwa.dto;

import lombok.Builder;
import lombok.Data;

@Builder
public record CarMarksFullDto(
        Long id,
        String model,
        String mark,
        String startYear,
        String endYear
) {
}
