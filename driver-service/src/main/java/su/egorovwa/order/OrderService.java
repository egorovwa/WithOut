package su.egorovwa.order;

import su.egorovwa.dto.location.DriverLocation;
import su.egorovwa.dto.order.RequestedOrder;
import su.egorovwa.model.Order;

import java.util.List;
import java.util.Optional;

public interface OrderService {
    List<Order> getOrdersForLocation(DriverLocation driverLocation);

    Optional<Order> requestOrders(List<RequestedOrder> requestedOrders);
}
