package BattleShips.softUni.model.binding;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

public class UserRegisterBindingModel {
    @Size(min = 3,max = 10)
    private String username;
    @Size(min = 5,max = 20)
    private String fullName;
    @Email
    private String email;
    @Size(min = 3)
    private String password;
    @Size(min = 3)
    private String confirmPassword;

    public UserRegisterBindingModel() {
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullName() {
        return this.fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return this.confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
