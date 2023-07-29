package su.egorovwa.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import su.egorovwa.dto.OrderForDriverDto;
import su.egorovwa.dto.mapers.OrderMaper;
import su.egorovwa.model.TaxiOrder;
import su.egorovwa.repository.OrderRepository;
import su.egorovwa.repository.fake.FakeOrders;
import su.egorovwa.service.OrderService;

import java.util.List;
@Service
@RequiredArgsConstructor
@Slf4j
public class OrderServiceImpl implements OrderService {
    private final OrderMaper orderMaper;
    private final FakeOrders orderRepository = new FakeOrders(); // TODO: 28.07.2023 удалить позорище
    @Override
    public List<OrderForDriverDto> getAll(Long driverId) {
        // TODO: 28.07.2023 driver id for statistic
      log.info("Request for order list");
        return orderRepository.findAll().stream().map(orderMaper::toOrderFoprDriverDto).toList();
    }
}
