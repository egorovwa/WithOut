package su.egorovwa.dto;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.Builder;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonTypeName("su.egorovwa.withoutchecksdriver.network.dto.NetworkData.AuthRequest")
public record AuthRequest(
        String userName,
        String password
) {
}
