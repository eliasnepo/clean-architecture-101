package br.com.cleanarch.infra.orders.persistence;

import br.com.cleanarch.domain.orders.Order;
import br.com.cleanarch.domain.orders.OrderGateway;
import br.com.cleanarch.infra.orders.persistence.jpa.OrderEntityJpa;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Primary
@Repository
public class OrderEntityManagerGateway implements OrderGateway {

    @Autowired
    private EntityManager entityManager;

    private final static Logger log = LoggerFactory.getLogger(OrderEntityManagerGateway.class);

    @Override
    @Transactional
    public Order create(Order order) {
        log.info("Inserting data by entity manager");

        OrderEntityJpa orderEntity = OrderEntityJpa.from(order);
        entityManager.persist(orderEntity);
        entityManager.flush();

        return OrderEntityJpa.toDomain(orderEntity);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        log.info("Deleting data by entity manager");
        entityManager.remove(entityManager.find(OrderEntityJpa.class, id));
    }

    @Override
    public Optional<Order> findById(Long id) {
        log.info("FindById data by entity manager");

        OrderEntityJpa orderEntity = entityManager.find(OrderEntityJpa.class, id);

        return Optional.of(OrderEntityJpa.toDomain(orderEntity));
    }

    @Override
    @Transactional
    public Order update(Order order) {
        log.info("Update data by entity manager");
        OrderEntityJpa orderEntity = entityManager.merge(OrderEntityJpa.from(order));

        return OrderEntityJpa.toDomain(orderEntity);
    }

    @Override
    public List<Order> findAll() {
        log.info("Finding all data by entity manager");

        String jpql = "SELECT o FROM OrderEntityJpa o";
        TypedQuery<OrderEntityJpa> query = entityManager.createQuery(jpql, OrderEntityJpa.class);

        return query.getResultList().stream().map(OrderEntityJpa::toDomain).collect(Collectors.toList());
    }

    @Override
    public boolean existsById(Long id) {
        log.info("Exists data by entity manager");

        OrderEntityJpa orderEntityJpa = entityManager.find(OrderEntityJpa.class, id);

        if (orderEntityJpa != null) {
            return true;
        }

        return false;
    }
}
