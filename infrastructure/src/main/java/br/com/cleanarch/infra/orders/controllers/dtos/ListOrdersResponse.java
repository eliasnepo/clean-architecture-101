package br.com.cleanarch.infra.orders.controllers.dtos;

import br.com.cleanarch.domain.orders.OrderSource;

public record ListOrdersResponse(Long id, Double price, OrderSource source) {
}
