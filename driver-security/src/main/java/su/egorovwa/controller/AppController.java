package su.egorovwa.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import su.egorovwa.client.Client;
import su.egorovwa.dto.LocationDto;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import su.egorovwa.dto.OrderForDriverDto;


import java.util.Date;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class AppController {
    private final Client client;

    @GetMapping("/orders")
    public List<OrderForDriverDto> getAll(){ //driver id for statist
        var result = List.of(OrderForDriverDto.builder()
                .createdAt(new Date().getTime())
                .build());
      log.info("result : {}", result);
        return result;
    }
    @GetMapping("/")
    public String tupoi(){
        return "nadddd";
    }

}
