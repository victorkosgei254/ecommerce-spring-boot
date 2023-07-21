package com.order_service.services;

import com.order_service.models.OrderRequest;
import com.order_service.repository.OrderRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
@Transactional
public class OrderService {

    private OrderRequestRepository orderRequestRepository;


    private final WebClient webClient;

    public OrderService(OrderRequestRepository orderRequestRepository, WebClient webClient) {
        this.orderRequestRepository = orderRequestRepository;
        this.webClient = webClient;
    }

    public String insertOrder(OrderRequest  orderRequest)
    {
        //Check to see if there are items in an inventory
        Integer qty = webClient
                .get()
                .uri("http://localhost:8082/inventory/3")
                .retrieve()
                .bodyToMono(Integer.class)
                .block()
        ;

        if ((qty != null) && (qty > 0))
        {

            orderRequestRepository.save(orderRequest);
            updateInventory();
            return  "Order successfully placed !";
        }
        return "Failed to place order";
    }

    public OrderRequest getOrder(Long id)
    {
        return orderRequestRepository.findById(id).orElse(null);
    }

    public List<OrderRequest> getOrders()
    {
        return orderRequestRepository.findAll();
    }

    public void updateInventory()
    {
        webClient
                .get()
                .uri("http://localhost:8082/inventory/update/3")
                .retrieve()
                .bodyToMono(Boolean.class)
                .block();

    }
}
