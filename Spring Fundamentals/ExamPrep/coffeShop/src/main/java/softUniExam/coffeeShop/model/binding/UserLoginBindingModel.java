package softUniExam.coffeeShop.model.binding;

import jakarta.validation.constraints.Size;

public class UserLoginBindingModel {
    @Size(min = 5,max = 20)
    private String username;
    @Size(min = 3)
    private String password;

    public UserLoginBindingModel() {
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
