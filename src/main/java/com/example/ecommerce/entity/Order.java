package com.example.ecommerce.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;
    private double totalAmount;
    private String status;
    @org.hibernate.annotations.CreationTimestamp
    private LocalDateTime orderDate;

    public Order() {}

    public Order(Long userId, double totalAmount) {
        this.userId = userId;
        this.totalAmount = totalAmount;
        this.status = "PLACED";
        this.orderDate = LocalDateTime.now();
    }

    public Long getId() { return id; }
    public Long getUserId() { return userId; }
    public double getTotalAmount() { return totalAmount; }
    public String getStatus() { return status; }
    public LocalDateTime getOrderDate() { return orderDate; }
    public void setStatus(String status) { this.status = status; }
}
