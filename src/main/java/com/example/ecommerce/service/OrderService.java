package com.example.ecommerce.service;

import com.example.ecommerce.entity.Order;
import com.example.ecommerce.repository.OrderRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class OrderService {
    private final OrderRepository repository;
    public OrderService(OrderRepository repository) { this.repository = repository; }

    public List<Order> getAll() { return repository.findAll(); }
    public List<Order> getByUser(Long userId) { return repository.findByUserId(userId); }
    public Order getById(Long id) { return repository.findById(id).orElseThrow(() -> new RuntimeException("Order not found")); }
    public Order create(Order order) { return repository.save(order); }
    public Order updateStatus(Long id, String status) {
        Order existing = getById(id);
        existing.setStatus(status);
        return repository.save(existing);
    }
    public void delete(Long id) { repository.deleteById(id); }
}
