package com.example.ecommerce.controller;

import com.example.ecommerce.entity.Order;
import com.example.ecommerce.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/orders")
public class OrderController {
    private final OrderService service;
    public OrderController(OrderService service) { this.service = service; }

    @GetMapping public List<Order> getAll() { return service.getAll(); }
    @GetMapping("/{id}") public Order getById(@PathVariable Long id) { return service.getById(id); }
    @GetMapping("/user/{userId}") public List<Order> getByUser(@PathVariable Long userId) { return service.getByUser(userId); }
    @PostMapping @ResponseStatus(HttpStatus.CREATED) public Order create(@RequestBody Order order) { return service.create(order); }

    @PatchMapping("/{id}/status")
    public Order updateStatus(@PathVariable Long id, @RequestParam String status) {
        return service.updateStatus(id, status);
    }

    @DeleteMapping("/{id}") @ResponseStatus(HttpStatus.NO_CONTENT) public void delete(@PathVariable Long id) { service.delete(id); }
}
