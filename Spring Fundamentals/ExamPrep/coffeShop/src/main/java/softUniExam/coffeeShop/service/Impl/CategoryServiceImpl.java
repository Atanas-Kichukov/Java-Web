package softUniExam.coffeeShop.service.Impl;

import org.springframework.stereotype.Service;
import softUniExam.coffeeShop.model.entity.CategoryEntity;
import softUniExam.coffeeShop.model.entity.enums.CategoryEnum;
import softUniExam.coffeeShop.repository.CategoryRepository;
import softUniExam.coffeeShop.service.CategoryService;

import java.util.Arrays;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void initializeCategories() {
        if (this.categoryRepository.count() == 0) {
            Arrays.stream(CategoryEnum.values())
                    .forEach(categoryNameEnum -> {

                        CategoryEntity category = new CategoryEntity();
                        category.setName(categoryNameEnum);

                        switch (categoryNameEnum) {
                            case COFFEE -> category.setNeededTime(2);
                            case DRINK -> category.setNeededTime(1);
                            case OTHER -> category.setNeededTime(5);
                            case CAKE -> category.setNeededTime(10);
                        }

                        this.categoryRepository.save(category);
                    });
        }
    }

    @Override
    public CategoryEntity findByCategoryEnum(CategoryEnum category) {
        return categoryRepository.
                findByName(category)
                .orElse(null);

    }
}
