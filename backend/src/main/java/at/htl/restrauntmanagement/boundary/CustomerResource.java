package at.htl.restrauntmanagement.boundary;

import at.htl.restrauntmanagement.control.CustomerRepository;
import at.htl.restrauntmanagement.entity.Customer;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Mutation;
import org.eclipse.microprofile.graphql.Query;

import java.util.List;

@GraphQLApi
@Path("/customer")
public class CustomerResource {

    @Inject
    CustomerRepository customerRepository;

    @Mutation
    public Customer addCustomer(Customer customer) {
        return customerRepository.saveCustomer(customer);
    }

    @GET
    @Path("allCustomer")
    @Produces(MediaType.APPLICATION_JSON)
    @Query("getAllCustomer")
    public List<Customer> getAllCustomer() {
        return customerRepository.getAllCustomer();
    }
}
