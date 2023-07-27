package su.egorovwa.dto;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;

import java.util.Date;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonTypeName("su.egorovwa.withoutchecksdriver.network.dto.NetworkData.AuthResponce")
public record AuthResponceDto(
        Long driverId,
        String token,
        Long issuedAt,
        Long expiresAt
) {
    public static AuthResponceDto create(AuthRespponce authRespponce){
        return new  AuthResponceDto(
                authRespponce.driverId(),
                authRespponce.token(),
                authRespponce.issuedAt().toInstant().getEpochSecond(),
                authRespponce.expiresAt().toInstant().getEpochSecond()
        );
    }
}
