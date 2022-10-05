package br.com.cleanarch.application.orders.create;

import br.com.cleanarch.application.UseCase;
import br.com.cleanarch.domain.orders.Order;
import br.com.cleanarch.domain.orders.OrderGateway;

public class CreateOrderUseCase extends UseCase<CreateOrderInput, CreateOrderOutput> {

    private final OrderGateway orderGateway;

    public CreateOrderUseCase(final OrderGateway orderGateway) {
        this.orderGateway = orderGateway;
    }

    @Override
    public CreateOrderOutput execute(CreateOrderInput createOrderInput) {
        Order order = new Order(createOrderInput.price(), false, createOrderInput.source());
        order = orderGateway.create(order);

        return new CreateOrderOutput(order.getId(), order.getPrice());
    }
}
