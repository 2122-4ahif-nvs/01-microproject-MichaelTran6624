package at.htl.restrauntmanagement.control;

import at.htl.restrauntmanagement.entity.Customer;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@ApplicationScoped
public class CustomerRepository {

    @Inject
    EntityManager em;

    @Transactional
    public void save(Customer customer) {
        em.persist(customer);
    }
}
