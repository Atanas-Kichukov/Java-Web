package BattleShips.softUni.Init;

import BattleShips.softUni.service.CategoryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {
    private final CategoryService categoryService;

    public DataInitializer(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Override
    public void run(String... args) throws Exception {
        categoryService.initializeCategories();
    }
}
