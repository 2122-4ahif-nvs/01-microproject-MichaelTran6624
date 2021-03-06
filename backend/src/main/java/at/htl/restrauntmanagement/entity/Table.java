package at.htl.restrauntmanagement.entity;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Entity
@javax.persistence.Table(name = "RE_TABLE")
public class Table {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "TA_TABLENR")
    @NotBlank(message = "TableNr cannot be empty")
    String tableNr;

    @Column(name = "TA_SEATS")
    @Min(message = "Seats have to be greater than 1", value = 1)
    @Max(message = "Seats cannot be greater than 10", value = 10)
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
        return String.format("id: %d \n TableNr: %s \n Seats: %d", id, tableNr, seats);
    }
}
