package br.com.cleanarch.domain.orders;

import br.com.cleanarch.domain.exceptions.DomainException;
import br.com.cleanarch.domain.validation.Error;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private Long id;
    private Double price;
    private Boolean isConsumed;
    private OrderSource source;

    public Order(Long id, Double price, Boolean isConsumed, OrderSource source) {
        this.id = id;
        this.price = price;
        this.isConsumed = isConsumed;
        this.source = source;
        validate(this);
    }

    public Order(Double price, Boolean isConsumed, OrderSource source) {
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

    public void changePrice(Double price) {
        this.price = price;
        validate(this);
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

    public OrderSource getSource() {
        return source;
    }

    private void validate(Order order) {
        List<Error> errors = new ArrayList<>();

        if (price <= 10.0) {
            errors.add(new Error("price", "order's value must be greater than $10"));
        } else if (isConsumed) {
            errors.add(new Error("isConsumed", "you can not create a order already consumed"));
        }

        if (errors.size() > 0) {
            throw new DomainException("error(s) happened while validate order", errors);
        }
    }
}
