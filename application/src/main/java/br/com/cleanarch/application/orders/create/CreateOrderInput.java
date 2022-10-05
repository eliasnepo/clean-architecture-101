package br.com.cleanarch.application.orders.create;

import br.com.cleanarch.domain.orders.OrderSource;

public record CreateOrderInput(Double price, OrderSource source) {
}
