package br.com.cleanarch.domain.orders;

import br.com.cleanarch.domain.exceptions.DomainException;

import java.math.BigDecimal;

public class Order {

    private Long id;
    private Double price;
    private Boolean isConsumed;
    private OrderSouce source;

    public Order(Long id, Double price, Boolean isConsumed, OrderSouce source) {
        this.id = id;
        this.price = price;
        this.isConsumed = isConsumed;
        this.source = source;
        validate(this);
    }

    public void consume() {
        if (isConsumed) {
            throw new DomainException("order already consumed");
        }
        this.isConsumed = true;
    }

    public Long getId() {
        return id;
    }

    public Double getPrice() {
        return price;
    }

    public Boolean getConsumed() {
        return isConsumed;
    }

    public OrderSouce getSource() {
        return source;
    }

    private void validate(Order order) {
        if (price <= 10.0) {
            throw new DomainException("order's value must be greater than $10");
        } else if (isConsumed) {
            throw new DomainException("you can not create a order already consumed");
        }
    }
}
