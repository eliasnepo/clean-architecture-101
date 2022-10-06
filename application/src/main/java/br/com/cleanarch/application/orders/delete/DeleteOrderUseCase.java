package br.com.cleanarch.application.orders.delete;

import br.com.cleanarch.application.InUseCase;
import br.com.cleanarch.application.exceptions.NotFoundException;
import br.com.cleanarch.domain.orders.OrderGateway;

import java.util.NoSuchElementException;

public class DeleteOrderUseCase extends InUseCase<Long> {

    private final OrderGateway orderGateway;

    public DeleteOrderUseCase(final OrderGateway orderGateway) {
        this.orderGateway = orderGateway;
    }

    @Override
    public void execute(Long id) {
        if (orderGateway.existsById(id)) {
            orderGateway.deleteById(id);
        } else {
            throw new NotFoundException("orders with id " + id + " does not exists");
        }
    }
}
