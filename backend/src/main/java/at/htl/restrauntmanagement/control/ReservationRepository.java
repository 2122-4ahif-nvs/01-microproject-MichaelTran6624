package at.htl.restrauntmanagement.control;

import at.htl.restrauntmanagement.entity.Customer;
import at.htl.restrauntmanagement.entity.Reservation;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@ApplicationScoped
public class ReservationRepository {

    @Inject
    EntityManager em;

    @Transactional
    public Reservation saveReservation(Reservation reservation) {
        em.merge(reservation.getCustomer());
        em.merge(reservation.getReservationTable());
        return em.merge(reservation);
    }

    public List<Reservation> getAllReservations() {
        TypedQuery<Reservation> query = em
                .createQuery("select r from Reservation r", Reservation.class);

        return query.getResultList();
    }

    public void validateReservation(@Valid Reservation reservation) {

    }

    public Reservation findById(Long id) {
        TypedQuery<Reservation> query = em
                .createQuery("select r from Reservation r where :ID = r.id", Reservation.class);

        query.setParameter("ID", id);

        return query.getSingleResult();
    }
}
