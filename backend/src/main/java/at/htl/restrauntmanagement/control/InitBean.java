package at.htl.restrauntmanagement.control;

import at.htl.restrauntmanagement.entity.Customer;
import at.htl.restrauntmanagement.entity.Reservation;
import at.htl.restrauntmanagement.entity.Table;
import io.quarkus.runtime.StartupEvent;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import java.time.LocalDate;

@ApplicationScoped
public class InitBean {

    @Inject
    CustomerRepository customerRepository;

    @Inject
    ReservationRepository reservationRepository;

    @Inject
    TableRepository tableRepository;

    void init(@Observes StartupEvent event){
        Customer c1 = customerRepository.saveCustomer(new Customer("Michael",
                        "Tran",
                        "MTRAN",
                        "P@ssword",
                        "admin"));

        Customer c2 = customerRepository.saveCustomer(new Customer(
                "Jan",
                "Huber",
                "Hueb",
                "hunter2",
                "customer"
        ));

        Customer c3 = customerRepository.saveCustomer(new Customer(
                "Timmy",
                "Tim",
                "TimerT",
                "IamCustomer1",
                "customer"
        ));

        Table t1 = tableRepository.saveTable(new Table("1L", 4));
        Table t2 = tableRepository.saveTable(new Table("2L", 2));
        Table t3 = tableRepository.saveTable(new Table("3L", 10));

        reservationRepository.saveReservation(new Reservation(LocalDate.now(), c2, t1));
        reservationRepository.saveReservation(new Reservation(LocalDate.now().plusMonths(2L), c3, t2));
        reservationRepository.saveReservation(new Reservation(LocalDate.now().plusWeeks(1L), c2, t3));
        reservationRepository.saveReservation(new Reservation(LocalDate.now().plusDays(3L), c1, t1));
    }
}
