package su.egorovwa.dto;

import lombok.Builder;

@Builder(toBuilder = true)
public record NewDriverDto(
        Long id,
        String phone,
        String fistName,
        String lastName,
        String password,
        String email) {
}


