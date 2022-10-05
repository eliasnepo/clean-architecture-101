package br.com.cleanarch.infra.orders.controllers;

import br.com.cleanarch.application.orders.create.CreateOrderUseCase;
import br.com.cleanarch.application.orders.delete.DeleteOrderUseCase;
import br.com.cleanarch.application.orders.retrieve.get.GetOrderByIdUseCase;
import br.com.cleanarch.application.orders.retrieve.list.ListOrdersUseCase;
import br.com.cleanarch.application.orders.update.UpdateOrderUseCase;
import br.com.cleanarch.infra.orders.controllers.dtos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

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


    @PostMapping
    public ResponseEntity<?> createOrder(@RequestBody CreateOrderRequest request) {
        // TODO: impl this
        return null;
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetOrderByIdResponse> getOrderById(@PathVariable Long id) {
        // TODO: impl this
        return null;
    }

    @GetMapping
    public ResponseEntity<ListOrdersResponse> listOrders() {
        // TODO: impl this
        return null;
    }

    @DeleteMapping("/{id}")
    public void listOrders(@PathVariable Long id) {
        // TODO: impl this
        return;
    }

    @PutMapping("/{id}")
    public ResponseEntity<UpdateOrderResponse> listOrders(@PathVariable Long id, @RequestBody UpdateOrderRequest request) {
        // TODO: impl this
        return null;
    }
}
