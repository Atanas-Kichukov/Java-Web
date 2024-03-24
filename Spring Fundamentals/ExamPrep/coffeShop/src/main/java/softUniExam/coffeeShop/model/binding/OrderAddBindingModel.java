package softUniExam.coffeeShop.model.binding;

import jakarta.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;
import softUniExam.coffeeShop.model.entity.enums.CategoryEnum;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class OrderAddBindingModel {
    @Size(min = 3,max = 20)
    private String name;
    @Positive
    @NotNull
    private BigDecimal price;
    @PastOrPresent
    @DateTimeFormat(pattern = "dd-MM-yyyy'T'HH:mm")
    private LocalDateTime orderTime;
    @NotNull
    private CategoryEnum category;
    @Size(min = 5)
    private String description;

    public OrderAddBindingModel() {
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
