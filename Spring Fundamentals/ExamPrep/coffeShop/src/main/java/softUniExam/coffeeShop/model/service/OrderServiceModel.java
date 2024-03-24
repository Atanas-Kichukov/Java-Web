package softUniExam.coffeeShop.model.service;

import softUniExam.coffeeShop.model.entity.UserEntity;
import softUniExam.coffeeShop.model.entity.enums.CategoryEnum;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class OrderServiceModel {
    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private LocalDateTime orderTime;
    private CategoryEnum category;
    private UserEntity employee;

    public OrderServiceModel() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public LocalDateTime getOrderTime() {
        return this.orderTime;
    }

    public void setOrderTime(LocalDateTime orderTime) {
        this.orderTime = orderTime;
    }

    public CategoryEnum getCategory() {
        return this.category;
    }

    public void setCategory(CategoryEnum category) {
        this.category = category;
    }

    public UserEntity getEmployee() {
        return this.employee;
    }

    public void setEmployee(UserEntity employee) {
        this.employee = employee;
    }
}
