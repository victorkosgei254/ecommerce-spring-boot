package com.krtmall.invertory_service.models;

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
@Table(name = "tbl_inventory")
public class Inventory {

    @Id
    @Column(name = "product_id")
    private Long id;

    @Column(name = "sku")
    private String sku;

    @Column(name = "qty")
    private Integer qty;
}
