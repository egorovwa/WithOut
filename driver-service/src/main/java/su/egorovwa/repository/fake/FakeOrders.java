package su.egorovwa.repository.fake;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import su.egorovwa.model.TaxiOrder;
import su.egorovwa.model.OrderStatus;
import su.egorovwa.model.Location;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;

@Component
public class FakeOrders {
    private List<TaxiOrder> taxiOrders;

    public FakeOrders() {
        taxiOrders = new ArrayList<>();
        init();
    }

    private void init() {
        TaxiOrder taxiOrder1 = TaxiOrder.builder()
                .createdAt(LocalDateTime.now().minus(Duration.ofMinutes(12)).toEpochSecond(ZoneOffset.UTC))
                .orderStatus(OrderStatus.WAIT_DRIVER)
                .startLocation(Location.builder()
                        .lat(53.34706395950028)
                        .lon(83.66532862216926)
                        .build())
                .endLocation(Location.builder() //
                        .lat(53.35572835903678)
                        .lon(83.67709130236801)
                        .build())
                .build();

        TaxiOrder taxiOrder2 = TaxiOrder.builder()
                .createdAt(LocalDateTime.now().minus(Duration.ofMinutes(1)).toEpochSecond(ZoneOffset.UTC))
                .orderStatus(OrderStatus.WAIT_DRIVER)
                .startLocation(Location.builder()
                        .lat(53.34706395950028)
                        .lon(83.66532862216926)
                        .build())
                .endLocation(Location.builder() //
                        .lat(53.35572835903678)
                        .lon(83.67709130236801)
                        .build())
                .build();
        taxiOrders.add(taxiOrder1);
        taxiOrders.add(taxiOrder2);
    }

    public List<TaxiOrder> findAll() {
        return taxiOrders;
    }
}

