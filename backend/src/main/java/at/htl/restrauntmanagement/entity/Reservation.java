package at.htl.restrauntmanagement.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    LocalDate reservationDate;

    @ManyToOne(cascade = CascadeType.PERSIST)
    Customer customer;

    @ManyToOne(cascade = CascadeType.PERSIST)
    Table table;

    //region constructors
    public Reservation() {
    }

    public Reservation(LocalDate reservationDate, Customer customer, Table table) {
        this.reservationDate = reservationDate;
        this.customer = customer;
        this.table = table;
    }
//endregion

    //region getter and setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(LocalDate reservationDate) {
        this.reservationDate = reservationDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Table getTable() {
        return table;
    }

    public void setTable(Table table) {
        this.table = table;
    }
    //endregion


    @Override
    public String toString() {
        return String.format("%d: %t %s %s", id, reservationDate, customer, table);
    }
}
