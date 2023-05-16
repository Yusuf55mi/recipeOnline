package com.yusuf.recipeOnline.controller;

import com.yusuf.recipeOnline.dto.FavoriteDto;
import com.yusuf.recipeOnline.model.Favorite;
import com.yusuf.recipeOnline.model.Recipe;
import com.yusuf.recipeOnline.model.User;
import com.yusuf.recipeOnline.repository.UserRepository;
import com.yusuf.recipeOnline.service.FavoriteService;
import com.yusuf.recipeOnline.service.RecipeService;
import com.yusuf.recipeOnline.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/favorite")
public class FavoriteController {

    private final FavoriteService favoriteService;
    private final UserService userService;
    private final RecipeService recipeService;

    public FavoriteController(FavoriteService favoriteService, UserRepository userRepository, UserService userService, RecipeService recipeService) {
        this.favoriteService = favoriteService;
        this.userService = userService;
        this.recipeService = recipeService;
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
    public Favorite createFavorite(@RequestBody FavoriteDto favoriteDto) {
        User user = userService.getById(favoriteDto.getUser_id());
        Recipe recipe = recipeService.getById(favoriteDto.getRecipe_id());
        Favorite favorite = new Favorite(user, recipe);
        return favoriteService.createFavorite(favorite);
    }

    @DeleteMapping("/{id}")
    public void deleteFavorite(@PathVariable Long id) {
        Favorite favorite = favoriteService.getFavoriteById(id);
        if (favorite != null) {
            favoriteService.deleteFavorite(favoriteService.getFavoriteById(favorite.getId()));
        }
    }
}

