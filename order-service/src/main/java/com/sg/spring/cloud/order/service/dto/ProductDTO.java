package com.sg.spring.cloud.order.service.dto;

import com.sg.spring.cloud.order.service.model.Product;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO (Data Transfer Object) used to serialize / deserialize {@link Product} objects
 *
 * @author bogdan.solga
 */
public class ProductDTO implements Serializable {

    private final int id;
    private final String productName;
    private final double price;

    public ProductDTO(final int id, final String productName, final double price) {
        this.id = id; this.productName = productName; this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getProductName() {
        return productName;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductDTO that = (ProductDTO) o;
        return id == that.id &&
                Double.compare(that.price, price) == 0 &&
                Objects.equals(productName, that.productName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, productName, price);
    }
}
