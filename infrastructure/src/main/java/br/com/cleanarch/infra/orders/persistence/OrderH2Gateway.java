package br.com.cleanarch.infra.orders.persistence;

import br.com.cleanarch.domain.orders.Order;
import br.com.cleanarch.domain.orders.OrderGateway;
import br.com.cleanarch.infra.orders.persistence.jpa.OrderEntityJpa;
import br.com.cleanarch.infra.orders.persistence.jpa.OrderRepositoryJpa;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private final static Logger log = LoggerFactory.getLogger(OrderH2Gateway.class);

    @Override
    public Order create(Order order) {
        log.info("Inserting data from JpaRepository");
        OrderEntityJpa orderEntity = orderRepository.save(OrderEntityJpa.from(order));
        return OrderEntityJpa.toDomain(orderEntity);
    }

    @Override
    public void deleteById(Long id) {
        log.info("Deleting data from JpaRepository");
        orderRepository.deleteById(id);
    }

    @Override
    public Optional<Order> findById(Long id) {
        log.info("FindById data from JpaRepository");
        Optional<Order> order = orderRepository.findById(id).map(OrderEntityJpa::toDomain);
        return order;
    }

    @Override
    public Order update(Order order) {
        log.info("Updating data from JpaRepository");
        OrderEntityJpa orderEntity = orderRepository.save(OrderEntityJpa.from(order));
        return OrderEntityJpa.toDomain(orderEntity);
    }

    @Override
    public List<Order> findAll() {
        log.info("Listing all data from JpaRepository");
        return orderRepository.findAll().stream().map(OrderEntityJpa::toDomain).collect(Collectors.toList());
    }

    @Override
    public boolean existsById(Long id) {
        log.info("Exists data from JpaRepository");
        return orderRepository.existsById(id);
    }
}
