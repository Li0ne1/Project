package com.example.controller;

import com.example.entity.Inventory;
import com.example.service.InventoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class InventoryController {

	private InventoryService inventoryService;
	
	public InventoryController(InventoryService inventoryService) {
		super();
		this.inventoryService = inventoryService;
	}
	
	@GetMapping("/admin")
	public String listInventory(Model model) {
		model.addAttribute("inventories", inventoryService.getAllInventories());
		return "admin";
	}

	@GetMapping("/admin/new")
	public String createInventory(Model model) {
		Inventory inventory = new Inventory();
		model.addAttribute("inventory", inventory);
		return "create_inventory";
	}

	@PostMapping("/admin")
	public String saveInventory(@ModelAttribute("inventory") Inventory inventory) {
		inventoryService.saveInventory(inventory);
		return "redirect:/admin";
	}

	@GetMapping("/admin/edit/{id}")
	public String editInventory(@PathVariable Long id, Model model) {
		model.addAttribute("inventory", inventoryService.getInventoryById(id));
		return "edit_inventory";
	}

	@PostMapping("/admin/{id}")
	public String updateInventory(@PathVariable Long id,
								  @ModelAttribute("inventory") Inventory inventory,
								  Model model) {
		Inventory existingInventory = inventoryService.getInventoryById(id);
		existingInventory.setId(id);
		existingInventory.setProductName(inventory.getProductName());
		existingInventory.setQuantity(inventory.getQuantity());
		existingInventory.setSize(inventory.getSize());
		existingInventory.setPrice(inventory.getPrice());
		inventoryService.updateInventory(existingInventory);
		return "redirect:/admin";
	}

	@GetMapping("/admin/{id}")
	public String deleteInventory(@PathVariable Long id) {
		inventoryService.deleteInventoryById(id);
		return "redirect:/admin";
	}
	
	
}


