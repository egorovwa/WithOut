package su.egorovwa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import su.egorovwa.model.Administrator;

import java.util.Optional;

public interface AdministratotRepository extends JpaRepository<Administrator, Long> {
    Optional<Administrator> findByName(String name);
}
