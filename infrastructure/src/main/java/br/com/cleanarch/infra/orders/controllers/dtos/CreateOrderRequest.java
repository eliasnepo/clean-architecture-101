package br.com.cleanarch.infra.orders.controllers.dtos;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public record CreateOrderRequest(@DecimalMin("10.0") Double price) {
}
