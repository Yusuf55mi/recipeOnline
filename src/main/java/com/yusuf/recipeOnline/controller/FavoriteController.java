package com.yusuf.recipeOnline.controller;

import com.yusuf.recipeOnline.model.Favorite;
import com.yusuf.recipeOnline.model.Recipe;
import com.yusuf.recipeOnline.model.User;
import com.yusuf.recipeOnline.service.FavoriteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/favorites")
public class FavoriteController {

    private final FavoriteService favoriteService;

    public FavoriteController(FavoriteService favoriteService) {
        this.favoriteService = favoriteService;
    }

    @GetMapping
    public List<Favorite> getAllFavorites() {
        return favoriteService.getAllFavorites();
    }

    @GetMapping("/{id}")
    public Favorite getFavoriteById(@PathVariable Long id) {
        return favoriteService.getFavoriteById(id);
    }

    @GetMapping("/user/{userId}")
    public List<Favorite> getFavoritesByUser(@PathVariable Long userId) {
        User user = new User();
        user.setId(userId);
        return favoriteService.getFavoritesByUser(user);
    }

    @GetMapping("/recipe/{recipeId}")
    public List<Favorite> getFavoritesByRecipe(@PathVariable Long recipeId) {
        Recipe recipe = new Recipe();
        recipe.setId(recipeId);
        return favoriteService.getFavoritesByRecipe(recipe);
    }

    @PostMapping
    public Favorite createFavorite(@RequestBody Favorite favorite) {
        return favoriteService.createFavorite(favorite);
    }

    @DeleteMapping("/{id}")
    public void deleteFavorite(@PathVariable Long id) {
        Favorite favorite = favoriteService.getFavoriteById(id);
        if (favorite != null) {
            favoriteService.deleteFavorite(favorite.getUser(), favorite.getRecipe());
        }
    }
}

