package com.krtmall.product_service.services;

import com.krtmall.product_service.models.Product;
import com.krtmall.product_service.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;
    public List<Product> getProduct()
    {
        return repository.findAll();
    }

    public Product getProduct(Long id)
    {
        return repository.findById(id).orElse(null);
    }


}
