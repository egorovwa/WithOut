package su.egorovwa.controller;

import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import su.egorovwa.dto.OrderForDriverDto;
import su.egorovwa.model.TaxiOrder;
import su.egorovwa.service.OrderService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;

    @GetMapping
    public List<OrderForDriverDto> getAll(@RequestParam(value = "driverId",required = false) Long driverId){ //driver id for statist
        return orderService.getAll(driverId);
    }

}
