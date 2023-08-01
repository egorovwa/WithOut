package su.egorovwa.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderPoint {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double lat;
    private double lon;

    public OrderPoint(double lat, double lon) {
        this.lat = lat;
        this.lon = lon;
    }
}
