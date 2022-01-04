package at.htl.restrauntmanagement.entity;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@javax.persistence.Table(name = "RE_CUSTOMER")
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

    //region constructors
    public Customer() {
    }

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
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
    //endregion

    @Override
    public String toString() {
        return String.format("id: %d \n Firstname: %s \n Lastname: %s", id, firstName, lastName);
    }

}
