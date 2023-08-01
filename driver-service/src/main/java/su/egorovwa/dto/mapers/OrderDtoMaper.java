package su.egorovwa.dto.mapers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import su.egorovwa.dto.order.OrderDto;
import su.egorovwa.model.Order;

import java.util.List;

@Component
@RequiredArgsConstructor
public class OrderDtoMaper {
    private final OrderPointDtoMaper orderPointDtoMaper;

    public OrderDto todto(Order order) {
        if (order.getTrackPoints() == null){
            order.setTrackPoints(List.of());
        }
       return new OrderDto(
               orderPointDtoMaper.toDto(order.getStartPoint()),
               orderPointDtoMaper.toDto(order.getEndPoint()),
               order.getTrackPoints().stream().map(orderPointDtoMaper::toDto).toList(),
               order.getCreatedAt()
               );
    }
}
