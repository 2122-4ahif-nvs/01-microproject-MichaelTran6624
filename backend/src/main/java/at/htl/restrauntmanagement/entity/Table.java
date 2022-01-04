package at.htl.restrauntmanagement.entity;

import javax.persistence.*;

@Entity
@javax.persistence.Table(name = "RE_TABLE")
public class Table {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "TA_TABLENR")
    String tableNr;

    @Column(name = "TA_SEATS")
    int seats;

    //region constructors
    public Table() {
    }

    public Table(String tableNr, int seats) {
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

    public String getTableNr() {
        return tableNr;
    }

    public void setTableNr(String tableNr) {
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
        return String.format("%d: %s: %d", id, tableNr, seats);
    }
}
