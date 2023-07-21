package com.krtmall.invertory_service.controller;

import com.krtmall.invertory_service.models.Inventory;
import com.krtmall.invertory_service.services.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;
    @GetMapping("/{id}")
    public Integer getQuantity(@PathVariable Long id)
    {
        return inventoryService.getQuantity(id);
    }

    @GetMapping("/update/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Boolean updateInventory(@PathVariable Long id)
    {
        return inventoryService.updateInventory(id);
    }

    @GetMapping
    public List<Inventory> getInventory()
    {
        return inventoryService.getAllInventoryItems();
    }
}
