package su.egorovwa.dto.order;

public record RequestedOrder(
        Long orderId,
        Float distance
){}
