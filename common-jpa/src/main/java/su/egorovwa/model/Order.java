package su.egorovwa.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    /**
     * начальный адрес
     */
    @ManyToOne
    private OrderPoint startPoint;
    /**
     * конечный адрес
     */
    @ManyToOne
    private OrderPoint endPoint;
    /**
     * промежуточные адреса
     */
    @ManyToMany
    private List<OrderPoint> trackPoints;
    /**
     * текущий статус заказа
     */
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;
    /**
     * время создания заказа
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
     * Время закрытия заказа
     */
    private Long closedAt;
    @ManyToOne
    private Driver driver;
    }
