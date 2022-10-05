package br.com.cleanarch.domain.orders;

import java.util.List;
import java.util.Optional;

public interface OrderGateway {

    Order create(Order order);

    void deleteById(Long id);

    Optional<Order> findById(Long id);

    Order update(Order order);

    List<Order> findAll();

    boolean existsById(Long id);

}
