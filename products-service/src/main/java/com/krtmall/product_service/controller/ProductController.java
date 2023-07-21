package com.krtmall.product_service.controller;

import com.krtmall.product_service.models.Product;
import com.krtmall.product_service.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public List<Product> getProduct()
    {
        return productService.getProduct();
    }

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable Long id)
    {
        return productService.getProduct(id);

    }
//
//    @PostMapping
//    public void insertProduct()
//    {
//
//    }
//
//    @PutMapping
//    public void updateProduct()
//    {
//
//    }
//
//    @DeleteMapping
//    public void deleteProduct()
//    {
//
//    }
}
