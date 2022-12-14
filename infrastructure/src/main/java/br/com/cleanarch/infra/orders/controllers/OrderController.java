package br.com.cleanarch.infra.orders.controllers;

import br.com.cleanarch.application.orders.create.CreateOrderInput;
import br.com.cleanarch.application.orders.create.CreateOrderUseCase;
import br.com.cleanarch.application.orders.delete.DeleteOrderUseCase;
import br.com.cleanarch.application.orders.retrieve.get.GetOrderByIdUseCase;
import br.com.cleanarch.application.orders.retrieve.list.ListOrdersUseCase;
import br.com.cleanarch.application.orders.update.UpdateOrderInput;
import br.com.cleanarch.application.orders.update.UpdateOrderUseCase;
import br.com.cleanarch.domain.orders.OrderSource;
import br.com.cleanarch.infra.orders.controllers.dtos.*;
import br.com.cleanarch.infra.orders.presenters.OrderPresenters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class OrderController implements OrderControllerAPI {

    @Autowired
    private CreateOrderUseCase createOrderUseCase;

    @Autowired
    private GetOrderByIdUseCase getOrderByIdUseCase;

    @Autowired
    private ListOrdersUseCase listOrdersUseCase;

    @Autowired
    private UpdateOrderUseCase updateOrderUseCase;

    @Autowired
    private DeleteOrderUseCase deleteOrderUseCase;


    public ResponseEntity<?> createOrder(CreateOrderRequest request) {
        var output = createOrderUseCase.execute(new CreateOrderInput(request.price(), OrderSource.API));

        return ResponseEntity.created(URI.create("/orders/" + output.id())).body(output);
    }

    public ResponseEntity<GetOrderByIdResponse> getOrderById(Long id) {
        var output = getOrderByIdUseCase.execute(id);
        var response = new GetOrderByIdResponse(output.id(), output.price(), output.isConsumed(), output.source());

        return ResponseEntity.ok(response);
    }

    public ResponseEntity<List<ListOrdersResponse>> listOrders() {
        var output = listOrdersUseCase.execute();
        var response = output
                .stream()
                .map(order -> OrderPresenters.present(order))
                .collect(Collectors.toList());

        return ResponseEntity.ok(response);
    }

    public ResponseEntity<?> deleteOrders(Long id) {
        deleteOrderUseCase.execute(id);
        return ResponseEntity.noContent().build();
    }

    public ResponseEntity<UpdateOrderResponse> updateOrder(Long id, UpdateOrderRequest request) {
        var output = updateOrderUseCase.execute(OrderPresenters.present(id, request));
        var response = new UpdateOrderResponse(output.id(), output.price(), output.isConsumed(), output.source());
        
        return ResponseEntity.ok(response);
    }
}
