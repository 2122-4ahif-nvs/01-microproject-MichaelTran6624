package at.htl.restrauntmanagement.entity;

import javax.persistence.*;

@Entity
@javax.persistence.Table(name = "RE_CUSTOMER")
public class Customer {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "CU_FIRSTNAME")
    String firstName;

    @Column(name = "CU_LASTNAME")
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
        return String.format("%d: %s %s", id, firstName, lastName);
    }

}
