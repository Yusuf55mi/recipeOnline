package com.yusuf.recipeOnline.repository;

import com.yusuf.recipeOnline.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {
}
