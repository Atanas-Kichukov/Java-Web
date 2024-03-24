package BattleShips.softUni.model.binding;

import BattleShips.softUni.model.entity.CategoryEntity;
import BattleShips.softUni.model.entity.enums.CategoryNameEnum;
import jakarta.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class ShipAddBindingModel {
    @Size(min = 2, max = 10)
    private String name;
    @Positive
    private Integer power;
    @Positive
    private Integer health;
    @PastOrPresent
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate created;
    @NotNull
    private CategoryNameEnum category;

    public ShipAddBindingModel() {
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPower() {
        return this.power;
    }

    public void setPower(Integer power) {
        this.power = power;
    }

    public Integer getHealth() {
        return this.health;
    }

    public void setHealth(Integer health) {
        this.health = health;
    }

    public LocalDate getCreated() {
        return this.created;
    }

    public void setCreated(LocalDate created) {
        this.created = created;
    }

    public CategoryNameEnum getCategory() {
        return this.category;
    }

    public void setCategory(CategoryNameEnum category) {
        this.category = category;
    }
}
