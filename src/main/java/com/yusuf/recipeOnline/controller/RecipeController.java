package com.yusuf.recipeOnline.controller;

import com.yusuf.recipeOnline.model.Recipe;
import com.yusuf.recipeOnline.model.User;
import com.yusuf.recipeOnline.service.RecipeService;
import com.yusuf.recipeOnline.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class RecipeController {

    private RecipeService recipeService;

    @Autowired
    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping
    public ResponseEntity<Recipe> getRecipes() {
        return new ResponseEntity<Recipe>((Recipe) recipeService.getAll(), HttpStatus.OK);
    }
}
