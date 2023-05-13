package com.yusuf.recipeOnline.service;

import com.yusuf.recipeOnline.model.Category;
import com.yusuf.recipeOnline.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id).orElse(null);
    }

    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    public Category updateCategory(Long id, Category category) {
        Category existingCategory = getCategoryById(id);
        if (existingCategory != null) {
            existingCategory.setName(category.getName());
            // Diğer alanları güncelleme
            return categoryRepository.save(existingCategory);
        }
        return null;
    }

    public boolean deleteCategory(Long id) {
        Category existingCategory = getCategoryById(id);
        if (existingCategory != null) {
            categoryRepository.delete(existingCategory);
            return true;
        }
        return false;
    }
}

