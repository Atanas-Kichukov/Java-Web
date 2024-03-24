package softUniExam.coffeeShop.model.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
public class OrderEntity extends BaseEntity{
    @Column(nullable = false)
    private String name;
    @Column(nullable = false,columnDefinition = "TEXT")
    private String description;
    @Column(nullable = false)
    private BigDecimal price;
    @Column(nullable = false)
    private LocalDateTime orderTime;
    @ManyToOne
    private CategoryEntity category;
    @ManyToOne
    private UserEntity employee;

    public OrderEntity() {
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

    public CategoryEntity getCategory() {
        return this.category;
    }

    public void setCategory(CategoryEntity category) {
        this.category = category;
    }

    public UserEntity getEmployee() {
        return this.employee;
    }

    public void setEmployee(UserEntity employee) {
        this.employee = employee;
    }
}
