package su.egorovwa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import su.egorovwa.model.Location;

public interface LocationRepository extends JpaRepository<Location, Long> {
}
