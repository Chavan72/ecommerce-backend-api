package com.example.ecommerce.service;

import com.example.ecommerce.entity.User;
import com.example.ecommerce.repository.UserRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {
    private final UserRepository repository;
    public UserService(UserRepository repository) { this.repository = repository; }

    public List<User> getAll() { return repository.findAll(); }
    public User getById(Long id) { return repository.findById(id).orElseThrow(() -> new RuntimeException("User not found")); }
    public User create(User user) { return repository.save(user); }
    public User update(Long id, User user) {
        User existing = getById(id);
        existing.setName(user.getName());
        existing.setEmail(user.getEmail());
        existing.setPhone(user.getPhone());
        return repository.save(existing);
    }
    public void delete(Long id) { repository.deleteById(id); }
}
