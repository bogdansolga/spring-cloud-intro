package com.sg.spring.cloud.product.service.repository;

import com.sg.spring.cloud.product.service.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {
}
