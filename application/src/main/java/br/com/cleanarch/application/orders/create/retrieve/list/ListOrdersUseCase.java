package br.com.cleanarch.application.orders.create.retrieve.list;

import br.com.cleanarch.application.OutUseCase;
import br.com.cleanarch.domain.orders.Order;
import br.com.cleanarch.domain.orders.OrderGateway;

import java.util.List;
import java.util.stream.Collectors;

public class ListOrdersUseCase extends OutUseCase<List<ListOrderOutput>> {

    private final OrderGateway orderGateway;

    public ListOrdersUseCase(final OrderGateway orderGateway) {
        this.orderGateway = orderGateway;
    }

    @Override
    public List<ListOrderOutput> execute() {
        List<Order> orders = orderGateway.findAll();

        return orders
                .stream()
                .map(order -> new ListOrderOutput(order.getId(), order.getPrice(), order.getSource()))
                .collect(Collectors.toList());
    }
}
