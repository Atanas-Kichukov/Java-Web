package softUniExam.coffeeShop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softUniExam.coffeeShop.model.entity.CategoryEntity;
import softUniExam.coffeeShop.model.entity.enums.CategoryEnum;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity,Long> {


    Optional<CategoryEntity> findByName(CategoryEnum categoryEnum);
}
