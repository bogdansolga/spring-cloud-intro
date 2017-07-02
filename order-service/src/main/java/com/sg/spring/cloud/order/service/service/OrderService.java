package com.sg.spring.cloud.order.service.service;

import com.sg.spring.cloud.order.service.dto.OrderDTO;
import com.sg.spring.cloud.order.service.dto.ProductDTO;
import com.sg.spring.cloud.order.service.model.Product;
import com.sg.spring.cloud.order.service.repository.OrderRepository;
import com.sg.spring.cloud.order.service.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(final OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void save(final OrderDTO orderDTO) {
        orderRepository.save(getDTOConverter().apply(orderDTO));
    }

    public OrderDTO get(final int id) {
        final Order order = Optional.ofNullable(orderRepository.findOne(id))
                                    .orElseThrow(() -> new IllegalArgumentException("There is no order with the id " + id));

        return getOrderConverter().apply(order);
    }

    public List<OrderDTO> getAll() {
        return StreamSupport.stream(orderRepository.findAll().spliterator(), false)
                            .map(getOrderConverter())
                            .collect(Collectors.toList());
    }

    public void update(final int id, final OrderDTO orderDTO) {
        final Order existingOrder = orderRepository.findOne(id);

        existingOrder.setProducts(orderDTO.getProducts()
                                          .stream()
                                          .map(productDTO -> new Product(productDTO.getId(), productDTO.getProductName(),
                                                  productDTO.getPrice(), existingOrder))
                                          .collect(Collectors.toSet()));

        orderRepository.save(existingOrder);
    }

    public void delete(final int id) {
        orderRepository.delete(id);
    }

    private Function<OrderDTO, Order> getDTOConverter() {
        return dto -> new Order();
    }

    private Function<Order, OrderDTO> getOrderConverter() {
        return order -> {
            final Set<Product> products = order.getProducts();
            return new OrderDTO(products.stream()
                                        .map(product ->
                                new ProductDTO(product.getId(), product.getName(), product.getPrice()))
                                        .collect(Collectors.toSet()),
                        products.stream()
                                .mapToDouble(Product::getPrice)
                                .sum()
                    );
        };
    }
}
