package br.com.cleanarch.application.orders.update;

import br.com.cleanarch.application.UseCase;
import br.com.cleanarch.domain.orders.Order;
import br.com.cleanarch.domain.orders.OrderGateway;

import java.util.NoSuchElementException;

public class UpdateOrderUseCase extends UseCase<UpdateOrderInput, UpdateOrderOutput> {

    private final OrderGateway orderGateway;

    public UpdateOrderUseCase(final OrderGateway orderGateway) {
        this.orderGateway = orderGateway;
    }

    @Override
    public UpdateOrderOutput execute(UpdateOrderInput updateOrderInput) {
        Order order = orderGateway.findById(updateOrderInput.id())
                .orElseThrow(() -> new NoSuchElementException("order does not exists"));

        order.changePrice(updateOrderInput.price());

        order = orderGateway.update(order);

        return new UpdateOrderOutput(order.getId(), order.getPrice(), order.getConsumed(), order.getSource());
    }
}
