package com.yusuf.recipeOnline.controller;

import com.yusuf.recipeOnline.model.Recipe;
import com.yusuf.recipeOnline.service.RecipeService;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.Part;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

@Controller
@RequestMapping("/recipe")
@MultipartConfig
public class RecipeController {

    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Recipe>> getAllRecipes() {
        List<Recipe> recipes = recipeService.getAll();
        
        return ResponseEntity.ok(recipes);
    }

    @GetMapping
    public String recipeList() {
        return "listRecipe";
    }

    @GetMapping("/{id}")
    public Recipe getRecipeById(@PathVariable Long id) {
        return recipeService.getById(id);
    }

    @PostMapping("/add")
    public ResponseEntity<Recipe> createRecipe(@RequestBody Recipe recipe) {
        return new ResponseEntity<Recipe>(recipeService.saveRecipe(recipe), HttpStatus.CREATED);
    }

    @GetMapping("/addRecipe")
    public String createRecipe() {
        return "addRecipe";
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
    public ResponseEntity<?> uploadImage(@PathVariable Long id, @RequestParam("file") MultipartFile file) throws IOException {
        recipeService.uploadFile(id, file);
        if (recipeService.getById(id) != null) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}