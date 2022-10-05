package br.com.cleanarch.infra.orders.controllers.dtos;

import br.com.cleanarch.domain.orders.OrderSource;

public record GetOrderByIdResponse(Long id, Double price, Boolean isConsumed, OrderSource source) {
}
