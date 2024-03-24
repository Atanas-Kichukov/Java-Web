package softUniExam.coffeeShop.init;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import softUniExam.coffeeShop.service.CategoryService;

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
