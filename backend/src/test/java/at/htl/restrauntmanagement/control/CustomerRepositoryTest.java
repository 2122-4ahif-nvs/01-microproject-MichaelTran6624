package at.htl.restrauntmanagement.control;

import at.htl.restrauntmanagement.entity.Customer;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import javax.validation.ConstraintViolationException;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

@QuarkusTest
class CustomerRepositoryTest {

    @Inject
    CustomerRepository customerRepository;

    @Test
    @Order(2000)
    void saveCustomer() {
        Customer customer = customerRepository.saveCustomer(new Customer("Michael","Tran"));

        assertThat(customer.getFirstName()).isEqualTo("Michael");
    }

    @Test
    @Order(2001)
    void getAllCustomer() {
        customerRepository.saveCustomer(new Customer("Michael", "Tran"));
        customerRepository.saveCustomer(new Customer("Max", "Muster"));

        List<Customer> customers = customerRepository.getAllCustomer();

        assertThat(customers.size()).isEqualTo(2);
    }

    @Test
    @Order(2002)
    void validateCustomer(){
        try{
            customerRepository.validateCustomer(new Customer("Michael","Tran"));
        }
        catch (ConstraintViolationException ex) {
            fail(ex.toString());
        }
    }
}