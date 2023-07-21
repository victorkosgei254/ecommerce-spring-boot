package com.order_service.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "tbl_orders")
public class OrderRequest {

    @Id
    @Column(name="productId")
    private Long id;


    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "featuredImage")
    private String featuredImage;

}
