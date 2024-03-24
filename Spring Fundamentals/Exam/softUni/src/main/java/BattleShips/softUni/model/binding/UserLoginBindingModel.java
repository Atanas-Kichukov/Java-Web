package BattleShips.softUni.model.binding;

import jakarta.validation.constraints.Size;

public class UserLoginBindingModel {
    @Size(min = 3,max = 10)
    private String username;

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

    @Size(min = 3)
    private String password;
}
