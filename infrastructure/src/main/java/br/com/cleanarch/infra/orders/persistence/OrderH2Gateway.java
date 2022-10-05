package br.com.cleanarch.infra.orders.persistence;

import br.com.cleanarch.domain.orders.Order;
import br.com.cleanarch.domain.orders.OrderGateway;
import br.com.cleanarch.infra.orders.persistence.jpa.OrderEntityJpa;
import br.com.cleanarch.infra.orders.persistence.jpa.OrderRepositoryJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Primary
@Repository
public class OrderH2Gateway implements OrderGateway {

    @Autowired
    private OrderRepositoryJpa orderRepository;

    @Override
    public Order create(Order order) {
        OrderEntityJpa orderEntity = orderRepository.save(OrderEntityJpa.from(order));
        return OrderEntityJpa.toDomain(orderEntity);
    }

    @Override
    public void deleteById(Long id) {
        orderRepository.deleteById(id);
    }

    @Override
    public Optional<Order> findById(Long id) {
        Optional<Order> order = orderRepository.findById(id).map(OrderEntityJpa::toDomain);
        return order;
    }

    @Override
    public Order update(Order order) {
        OrderEntityJpa orderEntity = orderRepository.save(OrderEntityJpa.from(order));
        return OrderEntityJpa.toDomain(orderEntity);
    }

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll().stream().map(OrderEntityJpa::toDomain).collect(Collectors.toList());
    }

    @Override
    public boolean existsById(Long id) {
        return orderRepository.existsById(id);
    }
}
