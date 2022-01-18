package at.htl.restrauntmanagement.control;

import at.htl.restrauntmanagement.entity.Customer;
import at.htl.restrauntmanagement.entity.Reservation;
import at.htl.restrauntmanagement.entity.Table;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import javax.validation.ConstraintViolationException;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
class ReservationRepositoryTest {

    @Inject
    ReservationRepository reservationRepository;

    @Test
    @Order(1000)
    void saveReservation() {
        Table table = new Table("1L", 3);
        Customer customer = new Customer("Michael", "Tran");
        LocalDate date = LocalDate.now();

        Reservation reservation = reservationRepository
                .saveReservation(new Reservation(date, customer, table));

        assertThat(reservation.getReservationDate()).isEqualTo(date);
    }

    @Test
    @Order(1001)
    void getAllReservations() {
        Table table = new Table("1L", 3);
        Customer customer = new Customer("Michael", "Tran");
        LocalDate date = LocalDate.now();

        reservationRepository.saveReservation(new Reservation(date, customer, table));
        reservationRepository.saveReservation(new Reservation(date.plusWeeks(1L), customer, table));

        List<Reservation> reservations = reservationRepository.getAllReservations();

        assertThat(reservations.size()).isEqualTo(2);
    }

    @Test
    @Order(1002)
    void validateReservation(){
        try{
            Table table = new Table("1L", 3);
            Customer customer = new Customer("Michael", "Tran");
            LocalDate date = LocalDate.now();
            reservationRepository.validateReservation(new Reservation(date, customer, table));
        }
        catch (ConstraintViolationException ex) {
            fail(ex.toString());
        }
    }
}