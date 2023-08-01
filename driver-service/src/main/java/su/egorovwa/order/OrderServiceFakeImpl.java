package su.egorovwa.order;

import org.springframework.stereotype.Service;
import su.egorovwa.dto.location.DriverLocation;
import su.egorovwa.dto.order.RequestedOrder;
import su.egorovwa.model.Order;
import su.egorovwa.model.OrderPoint;
import su.egorovwa.model.OrderStatus;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;
@Service
public class OrderServiceFakeImpl implements OrderService {
    @Override
    public List<Order> getOrdersForLocation(DriverLocation driverLocation) {
        return List.of(
                Order.builder()
                        .orderStatus(OrderStatus.WAIT_DRIVER)
                        .createdAt(new Date().getTime())
                        .startPoint(new OrderPoint(53.347603242939165, 83.67122143495173))
                        .endPoint(new OrderPoint(53.39160977847721, 83.68341866545418))
                        .build()
        );
    }

    @Override
    public Optional<Order> requestOrders(List<RequestedOrder> requestedOrders) {
        return Optional.empty();
    }
}
