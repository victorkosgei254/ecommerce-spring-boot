package com.krtmall.product_service.repository;

import com.krtmall.product_service.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
