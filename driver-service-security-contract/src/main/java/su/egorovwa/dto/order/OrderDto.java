package su.egorovwa.dto.order;

import lombok.Builder;
import su.egorovwa.dto.location.OrderPointDto;

import java.time.LocalDateTime;
import java.util.List;


public record OrderDto(
        OrderPointDto start,
        OrderPointDto end,
        List<OrderPointDto> trackPoints,
        Long createdAt

) {
}
