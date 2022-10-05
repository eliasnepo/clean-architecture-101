package br.com.cleanarch.application.orders.retrieve.list;

import br.com.cleanarch.domain.orders.OrderSource;

public record ListOrderOutput(Long id, Double price, OrderSource source) {
}
