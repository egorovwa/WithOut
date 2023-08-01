package su.egorovwa.driverstate;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import su.egorovwa.driver.DriverService;
import su.egorovwa.dto.mapers.OrderDtoMaper;
import su.egorovwa.dto.order.RequestedOrder;
import su.egorovwa.dto.state.DriverCurrentStatus;
import su.egorovwa.dto.state.DriverStateRequest;
import su.egorovwa.dto.state.DriverStateResponce;
import su.egorovwa.dto.state.StateResponceStatus;
import su.egorovwa.exception.ObjectNotFoundException;
import su.egorovwa.exception.ServerDataException;
import su.egorovwa.model.Driver;
import su.egorovwa.model.Order;
import su.egorovwa.order.OrderService;
import su.egorovwa.utils.DriverIdMaper;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DriverStateServiceImpl implements DriverStateService {
    private final DriverService driverService;
    private final DriverIdMaper driverIdMaper;
    private final OrderService orderService;
    private final OrderDtoMaper orderDtoMaper;

    @Override
    public DriverStateResponce proccesState(String driverId, DriverStateRequest request) throws ServerDataException {
        try {
            Driver driver = driverService.findById(driverIdMaper.decode(driverId));
            return proccesState(driver, request);
        } catch (ObjectNotFoundException e) {
            throw new ServerDataException(String.format("Driver with raw id %s not found", driverId));
        }
    }

    private DriverStateResponce proccesState(Driver driver, DriverStateRequest request) {
        DriverCurrentStatus status = request.driverRuntime().status();
        switch (status) {
            case FREE -> {
                return onFreeRequest(driver, request);
            }
            case IN_ORDER -> {
                return onInOrderReques(driver, request);
            }
        }
        return null;
    }

    private DriverStateResponce onInOrderReques(Driver driver, DriverStateRequest request) {
        return null;
    }

    private DriverStateResponce onFreeRequest(Driver driver, DriverStateRequest request) {
        List<RequestedOrder> requestedOrders = getRequestedOrders(request);
        List<Order> currentFreeOrders =  orderService.getOrdersForLocation(request.currentLocation());
        Optional<Order> assignedOrder = Optional.empty();
        StateResponceStatus responseStatus = StateResponceStatus.STANDATR;
        if (!requestedOrders.isEmpty()){
           assignedOrder = orderService.requestOrders(requestedOrders);
        }
        if (assignedOrder.isPresent()){
            return DriverStateResponce.builder()
                    .responceStatus(StateResponceStatus.NEW_ORDER)
                    .proposedOrder(assignedOrder.map(orderDtoMaper::todto).get())
                    .build();
        }
        return DriverStateResponce.builder()
                .currentOrders(currentFreeOrders.stream().map(orderDtoMaper::todto).toList())
                .responceStatus(responseStatus)
                .build();

    }

    private List<RequestedOrder> getRequestedOrders(DriverStateRequest request) {
       if (request.requestedOrders() != null && request.requestedOrders().size()>0){
            List<RequestedOrder> requestedOrders = request.requestedOrders();
            return requestedOrders;
        }
       else {
           return List.of();
       }
    }


}
