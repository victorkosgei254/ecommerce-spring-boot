package com.order_service.models;

import jakarta.persistence.*;

@Entity
@Table(name = "tbl_cart")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long cartId;

}
