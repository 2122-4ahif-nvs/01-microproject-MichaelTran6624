package at.htl.restrauntmanagement.entity;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
class ReservationTest {

    @Inject
    EntityManager em;

    @Test
    @Transactional
    void addReservatiion(){
        Table table = new Table(1L, 3);
        Customer customer = new Customer("Michael", "Tran");

        em.persist(new Reservation(LocalDate.now(), customer, table));
    }

}