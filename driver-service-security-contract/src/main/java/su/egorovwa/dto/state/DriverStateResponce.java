package su.egorovwa.dto.state;

import lombok.*;
import su.egorovwa.dto.order.OrderDto;

import java.util.List;
@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class DriverStateResponce {
    private OrderDto proposedOrder;
    private List<OrderDto> currentOrders;
    @NonNull
    private StateResponceStatus responceStatus;
    }
