package softUniExam.coffeeShop.model.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "users")
public class UserEntity extends BaseEntity {
    @Column(unique = true, nullable = false)
    private String username;
    @Column(nullable = true)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @Column(nullable = false)
    private String password;
    @Column(unique = true,nullable = false)
    private String email;
    @OneToMany(mappedBy = "employee",fetch = FetchType.EAGER)
    private Set<OrderEntity> orders;

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public Set<OrderEntity> getOrders() {
        return this.orders;
    }

    public void setOrders(Set<OrderEntity> orders) {
        this.orders = orders;
    }
}
