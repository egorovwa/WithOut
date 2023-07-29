package su.egorovwa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import su.egorovwa.model.TaxiOrder;

public interface OrderRepository extends JpaRepository<TaxiOrder, Long> {
}
