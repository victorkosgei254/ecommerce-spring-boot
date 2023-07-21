package com.krtmall.invertory_service.repository;

import com.krtmall.invertory_service.models.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {
}
