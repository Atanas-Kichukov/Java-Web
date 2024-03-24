package BattleShips.softUni.service.Impl;

import BattleShips.softUni.model.entity.CategoryEntity;
import BattleShips.softUni.model.entity.enums.CategoryNameEnum;
import BattleShips.softUni.repository.CategoryRepository;
import BattleShips.softUni.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void initializeCategories() {
        if (categoryRepository.count() != 0) {
            return;
        }
        Arrays.stream(CategoryNameEnum.values())
                .forEach(categoryNameEnum -> {
                    CategoryEntity category = new CategoryEntity();
                    switch (categoryNameEnum) {
                        case BATTLE -> category.setName(CategoryNameEnum.BATTLE);
                        case CARGO -> category.setName(CategoryNameEnum.CARGO);
                        case PATROL -> category.setName(CategoryNameEnum.PATROL);
                    }
                     categoryRepository.save(category);
                });
    }

    @Override
    public CategoryEntity findByCategoryNameEnum(CategoryNameEnum category) {

        return categoryRepository.findByName(category).orElse(null);
    }
}
