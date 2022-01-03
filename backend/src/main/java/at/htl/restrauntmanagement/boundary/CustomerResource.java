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
import org.jboss.logging.Logger;

import java.net.URI;
import java.util.List;

@Path("customer")
public class CustomerResource {

    @Inject
    Logger logger;

    @Inject
    CustomerRepository customerRepository;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addCustomer(
            @QueryParam("firstName") String firstName,
            @QueryParam("lastName") String lastName,
            @Context UriInfo uriInfo
            ) {
        Customer newCustomer = new Customer(
                firstName,
                lastName
        );
        logger.info(newCustomer);
        URI uri = uriInfo
                .getAbsolutePathBuilder()
                .path("42")
                .build();

        return Response.created(uri).build();
    }

    @Path("/all")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Customer> getAllCustomer() {
        return customerRepository.getAllCustomer();
    }

}
