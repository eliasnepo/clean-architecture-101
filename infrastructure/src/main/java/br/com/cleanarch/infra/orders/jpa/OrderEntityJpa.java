package br.com.cleanarch.infra.orders.jpa;

import br.com.cleanarch.domain.orders.OrderSource;
import br.com.cleanarch.domain.orders.Order;

import javax.persistence.*;

@Entity
@Table(name = "tb_orders")
public class OrderEntityJpa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Double price;

    @Column(nullable = false)
    private Boolean isConsumed;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private OrderSource source;

    @Deprecated
    public OrderEntityJpa() {}

    public OrderEntityJpa(Long id, Double price, Boolean isConsumed, OrderSource source) {
        this.id = id;
        this.price = price;
        this.isConsumed = isConsumed;
        this.source = source;
    }

    public OrderEntityJpa(Double price, Boolean isConsumed, OrderSource source) {
        this.price = price;
        this.isConsumed = isConsumed;
        this.source = source;
    }

    public static OrderEntityJpa from(Order order) {
        return new OrderEntityJpa(order.getId(), order.getPrice(), order.getConsumed(), order.getSource());
    }

    public static Order toDomain(OrderEntityJpa order) {
        return new Order(order.getId(), order.getPrice(), order.getConsumed(), order.getSource());
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
}
