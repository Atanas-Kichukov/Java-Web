package softUniExam.coffeeShop.service;

import softUniExam.coffeeShop.model.entity.CategoryEntity;
import softUniExam.coffeeShop.model.entity.enums.CategoryEnum;

public interface CategoryService {
    void initializeCategories();

    CategoryEntity findByCategoryEnum(CategoryEnum category);
}
