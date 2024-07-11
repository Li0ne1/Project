package com.example.service;

import com.example.entity.Inventory;

import java.util.List;

public interface InventoryService {
	
	List<Inventory> getAllInventories();

	Inventory saveInventory(Inventory inventory);

	Inventory getInventoryById(Long id);

	Inventory updateInventory(Inventory inventory);
	
	void decreaseInventoryQuantity(Long id, int quantityToDecrease);
	
	void deleteInventoryById(Long id);
}