package com.order_service;

import com.order_service.models.OrderRequest;
import com.order_service.repository.OrderRequestRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {

        SpringApplication.run(Main.class, args);
    }


    @Bean
    public CommandLineRunner initializeDB(OrderRequestRepository repository)
    {
        return runner ->{
            List<OrderRequest> orderRequests = Arrays.asList(
                    OrderRequest
                            .builder()
                            .id(100L)
                            .title("order one")
                            .description("Order description")
                            .featuredImage("Image here")
                            .build(),

                    OrderRequest
                            .builder()
                            .id(102L)
                            .title("order Two")
                            .description("Order description")
                            .featuredImage("Image here")
                            .build(),

                    OrderRequest
                            .builder()
                            .id(101L)
                            .title("order Four")
                            .description("Order description")
                            .featuredImage("Image here")
                            .build(),
                    OrderRequest
                            .builder()
                            .id(130L)
                            .title("order Thirty")
                            .description("Order description")
                            .featuredImage("Image here")
                            .build()
            );

            repository.saveAll(orderRequests);
        };
    }
}