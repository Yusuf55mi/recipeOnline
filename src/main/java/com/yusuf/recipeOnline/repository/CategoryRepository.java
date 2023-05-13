package com.yusuf.recipeOnline.repository;

import com.yusuf.recipeOnline.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    
}

