package com.sg.spring.cloud.order.service.dto;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

public class OrderDTO implements Serializable {

    private final Set<ProductDTO> products;
    private final double totalPrice;

    public OrderDTO(final Set<ProductDTO> products, final double totalPrice) {
        this.products = products; this.totalPrice = totalPrice;
    }

    public Set<ProductDTO> getProducts() {
        return products;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderDTO orderDTO = (OrderDTO) o;
        return Double.compare(orderDTO.totalPrice, totalPrice) == 0 &&
                Objects.equals(products, orderDTO.products);
    }

    @Override
    public int hashCode() {
        return Objects.hash(products, totalPrice);
    }
}
