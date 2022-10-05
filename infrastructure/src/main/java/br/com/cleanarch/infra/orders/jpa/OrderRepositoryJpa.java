package br.com.cleanarch.infra.orders.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepositoryJpa extends JpaRepository<OrderEntityJpa, Long> {
}
