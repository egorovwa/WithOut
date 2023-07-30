package su.egorovwa.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.Builder;
import lombok.Data;

@Builder(toBuilder = true)
@Data
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonTypeName("su.egorovwa.withoutchecksdriver.network.dto.NetworkData.ErrorApi")
public class ErrorApi {
    private ErrorCode errorCode;
    private String exceptionMessage;
    private String casus;
    private Long timeInMilis;
}
