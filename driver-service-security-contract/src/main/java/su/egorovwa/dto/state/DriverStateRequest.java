package su.egorovwa.dto.state;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import su.egorovwa.dto.order.RequestedOrder;
import su.egorovwa.dto.location.DriverLocation;
import su.egorovwa.dto.order.OrderDto;

import java.util.List;

/**
 * Состояние водителя в ответ получаем DriverStateResponce
 *
 * @param driverRuntime
 * @param currentLocation
 * @param currentOrder
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonTypeName("su.egorovwa.withoutchecksdriver.network.dto.NetworkData.DriverStateRequest")
public record DriverStateRequest(
        DriverRuntime driverRuntime,
        /**
         * Текущее положение водителя
         */
        DriverLocation currentLocation,
        /**
         * Если IN_ORDER то тукущий Order
         * если FREE то null
         */
        OrderDto currentOrder,
        /**
         * в статусе FREE запрошенные заказы
         */
        List<RequestedOrder> requestedOrders) {
}
