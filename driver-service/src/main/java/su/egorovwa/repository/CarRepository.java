package su.egorovwa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import su.egorovwa.model.Car;

public interface CarRepository extends JpaRepository<Car, Long> {
}
