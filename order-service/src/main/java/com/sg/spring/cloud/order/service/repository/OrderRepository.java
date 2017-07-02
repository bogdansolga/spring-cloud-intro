package com.sg.spring.cloud.order.service.repository;

import com.sg.spring.cloud.order.service.model.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * A simple Spring Data {@link CrudRepository} for the {@link Order} entity
 *
 * @author bogdan.solga
 */
@Repository
@SuppressWarnings("unused")
public interface OrderRepository extends CrudRepository<Order, Integer> {
}
