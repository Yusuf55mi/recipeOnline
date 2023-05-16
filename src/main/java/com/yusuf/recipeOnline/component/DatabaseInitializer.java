package com.yusuf.recipeOnline.component;

import com.yusuf.recipeOnline.model.Category;
import com.yusuf.recipeOnline.repository.CategoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseInitializer implements CommandLineRunner {

    private final CategoryRepository categoryRepository;

    public DatabaseInitializer(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        createInitialCategories();
    }

    private void createInitialCategories() {
        Category category1 = new Category("Tatlı");
        Category category2 = new Category("Ana Yemek");
        Category category3 = new Category("Ara Yemek");
        Category category4 = new Category("Çorba");
        Category category5 = new Category("İçecek");
        Category category6 = new Category("Aperitif");

        categoryRepository.save(category1);
        categoryRepository.save(category2);
        categoryRepository.save(category3);
        categoryRepository.save(category4);
        categoryRepository.save(category5);
        categoryRepository.save(category6);
    }
    
}
