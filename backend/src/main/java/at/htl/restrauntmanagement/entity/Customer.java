package at.htl.restrauntmanagement.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Customer {
    String firstName;
    String lastName;

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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
