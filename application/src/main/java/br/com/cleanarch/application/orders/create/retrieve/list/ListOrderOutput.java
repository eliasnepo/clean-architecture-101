package br.com.cleanarch.application.orders.create.retrieve.list;

import br.com.cleanarch.domain.orders.OrderSource;

public record ListOrderOutput(Long id, Double price, OrderSource source) {
}
