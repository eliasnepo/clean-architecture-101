package br.com.cleanarch.application.orders.create;

import br.com.cleanarch.domain.orders.OrderSouce;

public record CreateOrderInput(Double price, OrderSouce source) {
}
