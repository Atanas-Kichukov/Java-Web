package BattleShips.softUni.model.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "users")
public class UserEntity extends BaseEntity{
    @Column(nullable = false,unique = true)
    private String username;
    @Column(nullable = false)
    private String fullName;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false,unique = true)
    private String email;
    @OneToMany(mappedBy = "user",fetch = FetchType.EAGER)
    private List<ShipEntity> ships;

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

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<ShipEntity> getShips() {
        return this.ships;
    }

    public void setShips(List<ShipEntity> ships) {
        this.ships = ships;
    }
}
