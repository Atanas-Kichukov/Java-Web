package softUniExam.coffeeShop.model.view;

public class UserViewModel {
    private String username;
    private Integer orderCount;

    public UserViewModel() {
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getOrderCount() {
        return this.orderCount;
    }

    public void setOrderCount(Integer orderCount) {
        this.orderCount = orderCount;
    }
}
