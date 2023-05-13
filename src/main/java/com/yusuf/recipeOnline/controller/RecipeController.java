package com.yusuf.recipeOnline.controller;

import com.yusuf.recipeOnline.model.Recipe;
import com.yusuf.recipeOnline.service.RecipeService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/recipe")
public class RecipeController {

    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping
    public List<Recipe> getAllRecipes() {
        return recipeService.getAll();
    }

    @GetMapping("/{id}")
    public Recipe getRecipeById(@PathVariable Long id) {
        return recipeService.getById(id);
    }

    @PostMapping("/add")
    public Recipe createRecipe(@RequestBody Recipe recipe) {
        return recipeService.saveRecipe(recipe);
    }

    @PutMapping("update/{id}")
    public Recipe updateRecipe(@PathVariable Long id, @RequestBody Recipe updatedRecipe) {
        return recipeService.update(id, updatedRecipe);
    }

    @DeleteMapping("delete/{id}")
    public void deleteRecipe(@PathVariable Long id) {
        recipeService.deleteById(id);
    }

    @PostMapping("/{id}/photo")
    public void uploadPhoto(@PathVariable Long id, @RequestParam("file") MultipartFile file) {
        Recipe recipe = recipeService.getById(id);
        recipe.setPhoto(file);
        recipeService.saveRecipe(recipe);
    }

}

