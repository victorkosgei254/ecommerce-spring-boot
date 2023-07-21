package com.krtmall.invertory_service.services;

import com.krtmall.invertory_service.models.Inventory;
import com.krtmall.invertory_service.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class InventoryService {

    @Autowired
    private InventoryRepository repository;

    public Integer getQuantity(Long id)
    {
        Inventory inv = repository.findById(id).orElse(null);
        if (inv == null)
        {
            return (0);
        }

        return inv.getQty();
    }

    public Boolean updateInventory(Long id)
    {
        Inventory inventory = repository.findById(id).orElse(null);
        if (inventory != null)
        {
            inventory.setQty(inventory.getQty() - 1);
            repository.save(inventory);
            return (true);
        }
       return (false);
    }

    public List<Inventory> getAllInventoryItems()
    {
        return repository.findAll();
    }
}
