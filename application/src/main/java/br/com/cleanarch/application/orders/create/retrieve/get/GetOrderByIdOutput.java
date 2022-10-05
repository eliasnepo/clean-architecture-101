package br.com.cleanarch.application.orders.create.retrieve.get;

import br.com.cleanarch.domain.orders.OrderSource;

public record GetOrderByIdOutput(Long id, Double price, Boolean isConsumed, OrderSource source) {
}
