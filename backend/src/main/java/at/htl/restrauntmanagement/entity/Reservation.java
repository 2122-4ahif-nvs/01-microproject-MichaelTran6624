package at.htl.restrauntmanagement.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Entity
@javax.persistence.Table(name = "RE_RESERVATION")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "RE_RESERVATIONDATE")
    @NotBlank(message = "Date cannot be empty")
    LocalDate reservationDate;

    @NotBlank(message = "Customer cannot be empty")
    @ManyToOne(cascade = CascadeType.ALL)
    Customer customer;

    @NotBlank(message = "Reservationtable cannot be empty")
    @ManyToOne(cascade = CascadeType.ALL)
    Table reservationTable;

    //region constructors
    public Reservation() {
    }

    public Reservation(LocalDate reservationDate, Customer customer, Table reservationTable) {
        this.reservationDate = reservationDate;
        this.customer = customer;
        this.reservationTable = reservationTable;
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

    public Table getReservationTable() {
        return reservationTable;
    }

    public void setReservationTable(Table table) {
        this.reservationTable = table;
    }
    //endregion

    @Override
    public String toString() {
        return String.format("id: %d \n" +
                " Reservationdate: %t \n" +
                " Customer: %s \n" +
                " Reservationtable: %s", id, reservationDate, customer, reservationTable);
    }
}
