package BattleShips.softUni.model.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "ships")
public class ShipEntity extends BaseEntity {
    @Column(nullable = false,unique = true)
    private String name;
    @Column(nullable = false)
    private Integer health;
    @Column(nullable = false)
    private Integer power;
    @Column(nullable = false)
    private LocalDate created;
    @ManyToOne
    private CategoryEntity category;
    @ManyToOne
    private UserEntity user;

    public ShipEntity() {
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

    public CategoryEntity getCategory() {
        return this.category;
    }

    public void setCategory(CategoryEntity category) {
        this.category = category;
    }

    public UserEntity getUser() {
        return this.user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
}
