package su.egorovwa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import su.egorovwa.model.Point;

public interface PointRepository extends JpaRepository<Point, Long> {
}
