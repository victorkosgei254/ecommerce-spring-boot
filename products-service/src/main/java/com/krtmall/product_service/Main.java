package com.krtmall.product_service;


import com.krtmall.product_service.models.Product;
import com.krtmall.product_service.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Bean
    public CommandLineRunner setUp(ProductRepository repository)
    {
        List<Product> productList = Arrays.asList(
                Product.builder()
                        .title("Product One")
                        .description("This is a product description")
                        .featuredImage("url heree")
                        .build(),

                Product.builder()
                        .title("Product Two")
                        .description("This is a product description")
                        .featuredImage("url heree")
                        .build(),

                Product.builder()
                        .title("Product Three")
                        .description("This is a product description")
                        .featuredImage("url heree")
                        .build(),
                Product.builder()
                        .title("Product Four")
                        .description("This is a product description")
                        .featuredImage("url heree")
                        .build(),
                Product.builder()
                        .title("Product Five")
                        .description("This is a product description")
                        .featuredImage("url heree")
                        .build()
        );
        return runner -> {
            repository.saveAll(productList);
        };
    }
}