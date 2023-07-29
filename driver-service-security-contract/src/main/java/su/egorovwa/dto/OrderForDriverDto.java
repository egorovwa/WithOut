package su.egorovwa.dto;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.Builder;

import java.util.List;

@Builder(toBuilder = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonTypeName("su.egorovwa.withoutchecksdriver.network.dto.NetworkData.OrderForDriverDto")
public record OrderForDriverDto(
        LocationDto startLocation,
        LocationDto endLocation,
        List<LocationDto> trackLocations,
        Long createdAt // TODO: 28.07.2023 add passanger

) {
}
