package br.com.cleanarch.application.orders.retrieve.get;

import br.com.cleanarch.application.UseCase;
import br.com.cleanarch.domain.orders.Order;
import br.com.cleanarch.domain.orders.OrderGateway;

import java.util.NoSuchElementException;

public class GetOrderByIdUseCase extends UseCase<Long, GetOrderByIdOutput> {

    private final OrderGateway orderGateway;

    public GetOrderByIdUseCase(final OrderGateway orderGateway) {
        this.orderGateway = orderGateway;
    }

    @Override
    public GetOrderByIdOutput execute(Long id) {
        Order order = orderGateway.findById(id).orElseThrow(() -> new NoSuchElementException("order not found"));

        return new GetOrderByIdOutput(order.getId(), order.getPrice(), order.getConsumed(), order.getSource());
    }
}
