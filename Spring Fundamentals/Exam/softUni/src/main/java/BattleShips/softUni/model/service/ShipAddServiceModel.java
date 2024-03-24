package BattleShips.softUni.model.service;

import BattleShips.softUni.model.entity.CategoryEntity;
import BattleShips.softUni.model.entity.UserEntity;
import BattleShips.softUni.model.entity.enums.CategoryNameEnum;

import java.time.LocalDate;

public class ShipAddServiceModel {
    private String name;
    private Integer health;
    private Integer power;
    private LocalDate created;
    private CategoryNameEnum category;

    public ShipAddServiceModel() {
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getHealth() {
        return this.health;
    }

    public void setHealth(Integer health) {
        this.health = health;
    }

    public Integer getPower() {
        return this.power;
    }

    public void setPower(Integer power) {
        this.power = power;
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
