package su.egorovwa.service;

import su.egorovwa.dto.OrderForDriverDto;
import su.egorovwa.model.TaxiOrder;

import java.util.List;

public interface OrderService {
    List<OrderForDriverDto> getAll(Long driverId);
}
