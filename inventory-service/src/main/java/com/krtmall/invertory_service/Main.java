package com.krtmall.invertory_service;

import com.krtmall.invertory_service.models.Inventory;
import com.krtmall.invertory_service.repository.InventoryRepository;
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
    public CommandLineRunner init(InventoryRepository repository)
    {
        List<Inventory> inventories = Arrays.asList(
                Inventory
                        .builder()
                        .id(1L)
                        .qty(100)
                        .sku("SOAP-Menegai")
                        .build(),
                Inventory
                        .builder()
                        .id(2L)
                        .qty(1)
                        .sku("Electronics")
                        .build(),
                Inventory
                        .builder()
                        .id(2L)
                        .qty(10)
                        .sku("TVs")
                        .build(),
                Inventory
                        .builder()
                        .id(3L)
                        .qty(7)
                        .sku("Woofer")
                        .build()
        );
        return runner->{
            repository.saveAll(inventories);
        };
    }
}