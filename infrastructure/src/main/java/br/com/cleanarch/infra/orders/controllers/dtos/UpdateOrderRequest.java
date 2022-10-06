package br.com.cleanarch.infra.orders.controllers.dtos;

import javax.validation.constraints.DecimalMin;

public record UpdateOrderRequest(@DecimalMin("10.0") Double price) {
}
