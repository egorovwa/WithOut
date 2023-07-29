package su.egorovwa.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.Builder;

@Builder(toBuilder = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonTypeName("su.egorovwa.withoutchecksdriver.network.dto.NetworkData.NewDriverDto")
public class ErrorApi {
    @JsonFormat(shape = JsonFormat.Shape.OBJECT)
    private ErrorCode errorCode;
    private String exceptionMessage;
    private String casus;
    private Long time;
}