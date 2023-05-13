package com.yusuf.recipeOnline.repository;

import com.yusuf.recipeOnline.model.Favorite;
import com.yusuf.recipeOnline.model.Recipe;
import com.yusuf.recipeOnline.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FavoriteRepository extends JpaRepository<Favorite, Long> {

    List<Favorite> findByUser(User user);

    List<Favorite> findByRecipe(Recipe recipe);

    void deleteByUserAndRecipe(User user, Recipe recipe);
    
}

