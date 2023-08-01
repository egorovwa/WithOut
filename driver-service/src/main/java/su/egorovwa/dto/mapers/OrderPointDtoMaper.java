package su.egorovwa.dto.mapers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import su.egorovwa.dto.location.OrderPointDto;
import su.egorovwa.model.OrderPoint;

@Component
@RequiredArgsConstructor
public class OrderPointDtoMaper {
    private final AddresDtoMaper addresDtoMaper;
    OrderPointDto toDto(OrderPoint orderPoint){
        return new OrderPointDto(orderPoint.getLat(),orderPoint.getLon());
    }
}
