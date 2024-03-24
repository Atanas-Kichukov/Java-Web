package softUniExam.coffeeShop.model.view;

import softUniExam.coffeeShop.model.entity.CategoryEntity;

import java.math.BigDecimal;

public class OrderViewModel {
    private Long id;
    private String name;
    private BigDecimal price;
    private CategoryEntity category;

    public OrderViewModel() {
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

    public BigDecimal getPrice() {
        return this.price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public CategoryEntity getCategory() {
        return this.category;
    }

    public void setCategory(CategoryEntity category) {
        this.category = category;
    }
}
