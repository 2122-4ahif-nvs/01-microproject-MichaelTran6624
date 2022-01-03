package at.htl.restrauntmanagement.boundary;

import at.htl.restrauntmanagement.control.CustomerRepository;
import at.htl.restrauntmanagement.entity.Customer;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Mutation;
import org.eclipse.microprofile.graphql.Query;
import org.jboss.logging.Logger;

import java.net.URI;
import java.util.List;

@GraphQLApi
@Path("customer")
public class CustomerResource {

    @Inject
    Logger logger;

    @Inject
    CustomerRepository customerRepository;

    @Mutation
    public Customer addCustomer(Customer customer) {
        return customerRepository.saveCustomer(customer);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Query
    public List<Customer> getAllCustomer() {
        return customerRepository.getAllCustomer();
    }
}
