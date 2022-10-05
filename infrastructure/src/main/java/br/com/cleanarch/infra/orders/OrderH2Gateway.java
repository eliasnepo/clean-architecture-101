package br.com.cleanarch.infra.orders;

import br.com.cleanarch.domain.orders.Order;
import br.com.cleanarch.domain.orders.OrderGateway;

import java.util.List;
import java.util.Optional;

public class OrderH2Gateway implements OrderGateway {

    @Override
    public Order create(Order order) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public Optional<Order> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Order update(Order order) {
        return null;
    }

    @Override
    public List<Order> findAll() {
        return null;
    }

    @Override
    public boolean existsById(Long id) {
        return false;
    }
}
