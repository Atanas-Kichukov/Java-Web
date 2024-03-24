package softUniExam.coffeeShop.model.entity;

import jakarta.persistence.*;
import softUniExam.coffeeShop.model.entity.enums.CategoryEnum;

@Entity
@Table(name = "categories")
public class CategoryEntity extends BaseEntity {
    @Enumerated(EnumType.STRING)
    private CategoryEnum name;
    @Column(nullable = false)
    private Integer neededTime;

    public CategoryEntity() {
    }

    public CategoryEnum getName() {
        return this.name;
    }

    public void setName(CategoryEnum name) {
        this.name = name;
    }

    public Integer getNeededTime() {
        return this.neededTime;
    }

    public void setNeededTime(Integer neededTime) {
        this.neededTime = neededTime;
    }


}
