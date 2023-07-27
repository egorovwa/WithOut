package su.egorovwa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import su.egorovwa.model.Order;

public interface OrderRepository extends JpaRepository<Long, Order> {
}
