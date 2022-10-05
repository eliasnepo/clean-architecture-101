package br.com.cleanarch.infra.configuration.beans;

import br.com.cleanarch.application.orders.create.CreateOrderUseCase;
import br.com.cleanarch.application.orders.delete.DeleteOrderUseCase;
import br.com.cleanarch.application.orders.retrieve.get.GetOrderByIdUseCase;
import br.com.cleanarch.application.orders.retrieve.list.ListOrdersUseCase;
import br.com.cleanarch.application.orders.update.UpdateOrderUseCase;
import br.com.cleanarch.domain.orders.OrderGateway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrdersUseCasesBeans {

    private final OrderGateway orderGateway;

    public OrdersUseCasesBeans(final OrderGateway orderGateway) {
        this.orderGateway = orderGateway;
    }

    @Bean()
    public CreateOrderUseCase createOrderUseCase() {
        return new CreateOrderUseCase(orderGateway);
    }

    @Bean
    public DeleteOrderUseCase deleteOrderUseCase() {
        return new DeleteOrderUseCase(orderGateway);
    }

    @Bean
    public GetOrderByIdUseCase getOrderByIdUseCase() {
        return new GetOrderByIdUseCase(orderGateway);
    }

    @Bean
    public ListOrdersUseCase listOrdersUseCase() {
        return new ListOrdersUseCase(orderGateway);
    }

    @Bean
    public UpdateOrderUseCase updateOrderUseCase() {
        return new UpdateOrderUseCase(orderGateway);
    }
}
