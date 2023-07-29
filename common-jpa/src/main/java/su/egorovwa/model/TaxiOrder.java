package su.egorovwa.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class TaxiOrder { // TODO: 27.07.2023 без пасажира итд
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * начальный адрес
     */
    @ManyToOne
    private Location startLocation;
    /**
     * конечный адрес
     */
    @ManyToOne
    private Location endLocation;
    /**
     * промежуточные адреса
     */
    @ManyToMany
    private List<Location> trackLocations;
    /**
     * текущий статус заказа
     */
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;
    /**
     * время создания заказа в секундах
     */
    private Long createdAt;
    /**
     * время назначения водителя
     */
    private Long driverSelectedAt;
    /**
     * статус завершения заказа
     */
    @Enumerated(EnumType.STRING)
    private OrderCloseStatus orderCloseStatus;
    /**
     * Время закрытия заказа в секундах
     */
    private LocalDateTime closedAt;
    @ManyToOne
    private Driver driver;
    }
