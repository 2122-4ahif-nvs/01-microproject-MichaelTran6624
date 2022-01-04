package at.htl.restrauntmanagement.control;

import at.htl.restrauntmanagement.entity.Customer;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@ApplicationScoped
public class CustomerRepository {

    @Inject
    EntityManager em;

    @Transactional
    public Customer saveCustomer(Customer customer) {
        return em.merge(customer);
    }

    public List<Customer> getAllCustomer(){
        TypedQuery<Customer> query = em
                .createQuery("select c from Customer c",
                        Customer.class);

        return query.getResultList();
    }

    public void validateCustomer(@Valid Customer customer) {

    }

    public Customer findById(Long id) {
        TypedQuery<Customer> query = em
                .createQuery("select c from Customer c where :ID = c.id", Customer.class);

        query.setParameter("ID", id);
        return query.getSingleResult();
    }
}
