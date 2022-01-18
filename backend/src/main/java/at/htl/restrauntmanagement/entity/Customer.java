package at.htl.restrauntmanagement.entity;

import io.quarkus.security.jpa.Password;
import io.quarkus.security.jpa.Roles;
import io.quarkus.security.jpa.UserDefinition;
import io.quarkus.security.jpa.Username;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@javax.persistence.Table(name = "RE_CUSTOMER")
@UserDefinition
public class Customer {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "CU_FIRSTNAME")
    @Size(message = "Firstname length has to be between 2 and 40", min = 2, max = 40)
    @NotBlank(message = "Firstname cannot be empty")
    String firstName;

    @Column(name = "CU_LASTNAME")
    @Size(message = "Lastname length has to be between 2 and 40", min = 2, max = 40)
    @NotBlank(message = "Lastname cannot be empty")
    String lastName;

    @Column(name = "CU_USERNAME")
    @NotBlank(message = "Username cannot be empty")
    @Username
    String username;

    @Column(name = "CU_PASSWORD")
    @NotBlank(message = "Password cannot be empty")
    @Password
    String password;

    @Column(name = "CU_ROLE")
    @NotBlank(message = "Role cannot be empty")
    @Roles
    String role;

    //region constructors
    public Customer() {
    }

    public Customer(String firstName, String lastName, String username, String password, String role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.role = role;
    }
    //endregion

    //region getter and setter
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    //endregion

    @Override
    public String toString() {
        return String.format("id: %d \n Firstname: %s \n Lastname: %s", id, firstName, lastName);
    }

}
