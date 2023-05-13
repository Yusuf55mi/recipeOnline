package com.yusuf.recipeOnline.service;

import com.yusuf.recipeOnline.model.Recipe;
import com.yusuf.recipeOnline.model.User;
import com.yusuf.recipeOnline.repository.RecipeRepository;
import com.yusuf.recipeOnline.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeService {
    private final RecipeRepository repository;

    @Autowired
    public RecipeService(RecipeRepository repository) {
        this.repository = repository;
    }

    public Recipe saveRecipe(Recipe recipe) {
        return repository.save(recipe);
    }

    public Recipe getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + id));
    }

    public List<Recipe> getAll() {
        return repository.findAll();
    }

    public void update(Recipe entity) {
        repository.save(entity);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

}
