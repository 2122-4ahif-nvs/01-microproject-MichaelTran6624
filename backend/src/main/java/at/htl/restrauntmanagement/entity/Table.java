package at.htl.restrauntmanagement.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Table {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    Long tableNr;

    int seats;

    //region constructors
    public Table() {
    }

    public Table(Long tableNr, int seats) {
        this.tableNr = tableNr;
        this.seats = seats;
    }
    //endregion

    //region getter and setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTableNr() {
        return tableNr;
    }

    public void setTableNr(Long tableNr) {
        this.tableNr = tableNr;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }
    //endregion


    @Override
    public String toString() {
        return String.format("%d: TableNr: %d Seats: %d", id, tableNr, seats);
    }
}
