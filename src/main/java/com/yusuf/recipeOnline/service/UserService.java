package com.yusuf.recipeOnline.service;

import com.yusuf.recipeOnline.model.User;
import com.yusuf.recipeOnline.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private UserRepository userRepository;
    
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public String getUserPassword(String email) {
        User user = userRepository.findByEmail(email);
        if (user != null) {
            return user.getPassword();
        } else {
            return null;
        }
    }

    public User getById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + id));
    }

    public User getByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public void update(User entity) {
        userRepository.save(entity);
    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

}
