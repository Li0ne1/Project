package com.example.controller;

import com.example.entity.Order;
import com.example.entity.Inventory;
import com.example.service.OrderService;
import com.example.service.InventoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class OrderController {

    private final OrderService orderService;
    private final InventoryService inventoryService;

    public OrderController(OrderService orderService, InventoryService inventoryService) {
        this.orderService = orderService;
        this.inventoryService = inventoryService;
    }

    @GetMapping("/orders/new")
    public String createOrderForm(Model model) {
        model.addAttribute("order", new Order());
        return "create_order";
    }
    
    
    @PostMapping("/orders")
    public String saveOrder(@ModelAttribute("order") Order order, Model model) {
        Inventory inventory = inventoryService.getInventoryById(order.getProductId());

        if (inventory != null && inventory.getQuantity() >= order.getQuantity()) {
            inventory.setQuantity(inventory.getQuantity() - order.getQuantity());
            inventoryService.updateInventory(inventory);
            orderService.saveOrder(order);
            return "redirect:/orders/" + order.getId();
        } else {
            model.addAttribute("error", "Not enough inventory for the requested product.");
            return "create_order";
        }
    }

    @GetMapping("/orders/{id}")
    public String viewOrder(@PathVariable Long id, Model model) {
        Order order = orderService.getOrderById(id);
        model.addAttribute("order", order);
        return "order";
    }
}
