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

    @GetMapping("/orders/new1")
    public String createOrderForm1(Model model) {
        model.addAttribute("order", new Order());
        return "create_order1";
    }

    @GetMapping("/orders/new2")
    public String createOrderForm2(Model model) {
        model.addAttribute("order", new Order());
        return "create_order2";
    }

    @GetMapping("/orders/new3")
    public String createOrderForm3(Model model) {
        model.addAttribute("order", new Order());
        return "create_order3";
    }

    @GetMapping("/orders/new4")
    public String createOrderForm4(Model model) {
        model.addAttribute("order", new Order());
        return "create_order4";
    }

    @GetMapping("/orders/new5")
    public String createOrderForm5(Model model) {
        model.addAttribute("order", new Order());
        return "create_order5";
    }

    @GetMapping("/orders/new6")
    public String createOrderForm6(Model model) {
        model.addAttribute("order", new Order());
        return "create_order6";
    }

    @GetMapping("/orders/new7")
    public String createOrderForm7(Model model) {
        model.addAttribute("order", new Order());
        return "create_order7";
    }

    @GetMapping("/orders/new8")
    public String createOrderForm8(Model model) {
        model.addAttribute("order", new Order());
        return "create_order8";
    }

    @GetMapping("/orders/new9")
    public String createOrderForm9(Model model) {
        model.addAttribute("order", new Order());
        return "create_order9";
    }

    @PostMapping("/orders")
    public String saveOrder(@ModelAttribute("order") Order order, Model model) {
        Inventory inventory = inventoryService.getInventoryById(order.getProductId());

        if (inventory != null && inventory.getQuantity() >= order.getQuantity()) {
            inventory.setQuantity(inventory.getQuantity() - order.getQuantity());
            inventoryService.updateInventory(inventory);
            Long id = orderService.saveOrder(order);
            return "redirect:/mainPage"
                    ;
        } else {
            model.addAttribute("error", "Not enough inventory for the requested product.");
            Long orderId = order.getOrderId();
            return "create_order" + orderId;
        }
    }

    @GetMapping("/orders/{id}")
    public String viewOrder(@PathVariable Long id, Model model) {
        Order order = orderService.getOrderById(id);
        model.addAttribute("order", order);
        return "order";
    }
}
