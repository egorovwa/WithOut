package su.egorovwa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import su.egorovwa.model.CarMark;

public interface MarkRepository extends JpaRepository<CarMark, Long> {
}
