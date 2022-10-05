package br.com.cleanarch.application.orders.create.retrieve.update;

import br.com.cleanarch.domain.orders.OrderSource;

public record UpdateOrderOutput(Long id, Double price, Boolean isConsumed, OrderSource source) {
}
