package at.htl.restrauntmanagement.boundary;

import at.htl.restrauntmanagement.control.CustomerRepository;
import at.htl.restrauntmanagement.entity.Customer;

import javax.inject.Inject;

import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Mutation;
import org.eclipse.microprofile.graphql.Query;

import java.util.List;

@GraphQLApi
public class CustomerResource {

    @Inject
    CustomerRepository customerRepository;

    @Mutation
    public Customer addCustomer(Customer customer) {
        return customerRepository.saveCustomer(customer);
    }

    @Query("allCustomer")
    public List<Customer> getAllCustomer() {
        return customerRepository.getAllCustomer();
    }
}
