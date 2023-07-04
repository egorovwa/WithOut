package su.egorovwa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import su.egorovwa.model.Driver;

public interface DriverRepository extends JpaRepository<Driver, Long> {
}
