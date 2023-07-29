package su.egorovwa.dto.mapers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import su.egorovwa.dto.OrderForDriverDto;
import su.egorovwa.model.TaxiOrder;

@Component
@RequiredArgsConstructor
public class OrderMaper {
    private final LocationDtoMaper locationDtoMaper;

    public OrderForDriverDto toOrderFoprDriverDto(TaxiOrder taxiOrder){
        return OrderForDriverDto.builder()
                .createdAt(taxiOrder.getCreatedAt())
                .startLocation(locationDtoMaper.toDto(taxiOrder.getStartLocation()))
                .endLocation(locationDtoMaper.toDto(taxiOrder.getEndLocation()))
                .build();
    }
}
