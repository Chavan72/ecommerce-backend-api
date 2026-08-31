package com.example.ecommerce.service;

import com.example.ecommerce.entity.Product;
import com.example.ecommerce.repository.ProductRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductService {
    private final ProductRepository repository;
    public ProductService(ProductRepository repository) { this.repository = repository; }

    public List<Product> getAll() { return repository.findAll(); }
    public Product getById(Long id) { return repository.findById(id).orElseThrow(() -> new RuntimeException("Product not found")); }
    public Product create(Product product) { return repository.save(product); }
    public Product update(Long id, Product product) {
        Product existing = getById(id);
        existing.setName(product.getName());
        existing.setDescription(product.getDescription());
        existing.setPrice(product.getPrice());
        existing.setStock(product.getStock());
        return repository.save(existing);
    }
    public void delete(Long id) { repository.deleteById(id); }
}
