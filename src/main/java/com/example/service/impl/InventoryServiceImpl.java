package com.example.service.impl;

import com.example.entity.Inventory;
import com.example.service.InventoryService;
import com.example.repository.InventoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryServiceImpl implements InventoryService {
	
	private InventoryRepository inventoryRepo;
	
	public InventoryServiceImpl(InventoryRepository inventoryRepo) {
		super();
		this.inventoryRepo = inventoryRepo;
	}
	
	@Override
	public List<Inventory> getAllInventories() {
		return inventoryRepo.findAll();
	}

	@Override
	public Inventory saveInventory(Inventory inventory) {
		return inventoryRepo.save(inventory);
	}

	@Override
	public Inventory getInventoryById(Long id) {
		return inventoryRepo.findById(id).get();
	}

	@Override
	public Inventory updateInventory(Inventory inventory) {
		return inventoryRepo.save(inventory);
	}
	
	@Override
    public void decreaseInventoryQuantity(Long id, int quantityToDecrease) {
        Inventory inventory = inventoryRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Inventory not found with id: " + id));
        
        int currentQuantity = inventory.getQuantity();
        if (currentQuantity < quantityToDecrease) {
            throw new IllegalArgumentException("Not enough inventory available");
        }
        
        inventory.setQuantity(currentQuantity - quantityToDecrease);
        inventoryRepo.save(inventory);
    }
	
	@Override
	public void deleteInventoryById(Long id) {
		inventoryRepo.deleteById(id);
	}
}
