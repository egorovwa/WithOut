package su.egorovwa.dto.driver;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.Builder;

@Builder(toBuilder = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonTypeName("su.egorovwa.withoutchecksdriver.network.dto.NetworkData.NewDriverDto")
public record NewDriverDto(
        Long id,
        String phone,
        String fistName,
        String lastName,
        String password,
        String email) {
}


