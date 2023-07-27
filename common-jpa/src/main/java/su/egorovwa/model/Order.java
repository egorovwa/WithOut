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
    private Point startPoint;
    /**
     * конечный адрес
     */
    @ManyToOne
    private Point endPoint;
    /**
     * промежуточные адреса
     */
    @ManyToMany
    private List<Point> trackPoints;
    /**
     * текущий статус заказа
     */
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;
    /**
     * время создания заказа
     */
    private LocalDateTime createdAt;
    /**
     * время назначения водителя
     */
    private LocalDateTime driverSelectedAt;
    /**
     * статус завершения заказа
     */
    @Enumerated(EnumType.STRING)
    private OrderCloseStatus orderCloseStatus;
    /**
     * Время закрытия заказа
     */
    private LocalDateTime closedAt;
    @ManyToOne
    private Driver driver;
    }
