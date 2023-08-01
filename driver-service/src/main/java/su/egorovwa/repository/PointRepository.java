package su.egorovwa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import su.egorovwa.model.OrderPoint;

public interface PointRepository extends JpaRepository<OrderPoint, Long> {
}
