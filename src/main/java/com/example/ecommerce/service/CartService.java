package com.example.ecommerce.service;

import com.example.ecommerce.entity.CartItem;
import com.example.ecommerce.repository.CartItemRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CartService {
    private final CartItemRepository repository;
    public CartService(CartItemRepository repository) { this.repository = repository; }

    public CartItem add(CartItem item) { return repository.save(item); }
    public List<CartItem> getByUser(Long userId) { return repository.findByUserId(userId); }
    public CartItem update(Long id, CartItem item) {
        CartItem existing = repository.findById(id).orElseThrow(() -> new RuntimeException("Cart item not found"));
        existing.setQuantity(item.getQuantity());
        return repository.save(existing);
    }
    public void remove(Long id) { repository.deleteById(id); }
}
