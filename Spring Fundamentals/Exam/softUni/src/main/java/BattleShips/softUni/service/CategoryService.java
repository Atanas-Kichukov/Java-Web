package BattleShips.softUni.service;

import BattleShips.softUni.model.entity.CategoryEntity;
import BattleShips.softUni.model.entity.enums.CategoryNameEnum;

public interface CategoryService {

    void initializeCategories();

    CategoryEntity findByCategoryNameEnum(CategoryNameEnum category);
}
