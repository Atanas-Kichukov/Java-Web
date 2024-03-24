package BattleShips.softUni.model.entity;

import BattleShips.softUni.model.entity.enums.CategoryNameEnum;
import jakarta.persistence.*;

@Entity
@Table(name = "categories")
public class CategoryEntity extends BaseEntity {
    @Enumerated(EnumType.STRING)
    private CategoryNameEnum name;
    @Column(columnDefinition = "TEXT")
    private String description;

    public CategoryNameEnum getName() {
        return this.name;
    }

    public void setName(CategoryNameEnum name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
