package at.htl.restrauntmanagement.boundary;

import at.htl.restrauntmanagement.control.CustomerRepository;
import at.htl.restrauntmanagement.control.ReservationRepository;
import at.htl.restrauntmanagement.control.TableRepository;
import at.htl.restrauntmanagement.entity.Customer;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import at.htl.restrauntmanagement.entity.Reservation;
import at.htl.restrauntmanagement.entity.Table;
import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Mutation;
import org.eclipse.microprofile.graphql.Query;

import java.util.List;

@GraphQLApi
@Path("/customer")
public class CustomerResource {

    @Inject
    CustomerRepository customerRepository;

    @Inject
    TableRepository tableRepository;

    @Inject
    ReservationRepository reservationRepository;

    @Mutation
    public Customer addCustomer(Customer customer) {
        return customerRepository.saveCustomer(customer);
    }

    @Mutation
    public Table addTable(Table table){
        return tableRepository.saveTable(table);
    }

    @Mutation
    public Reservation addReservation(Reservation reservation) {
        return reservationRepository.saveReservation(reservation);
    }

    @GET
    @Path("allCustomer")
    @Produces(MediaType.APPLICATION_JSON)
    @Query("getAllCustomer")
    public List<Customer> getAllCustomer() {
        return customerRepository.getAllCustomer();
    }

    @GET
    @Path("allTables")
    @Produces(MediaType.APPLICATION_JSON)
    @Query("getAllTables")
    public List<Table> getAllTables(){
        return tableRepository.getAllTables();
    }

    @GET
    @Path("allReservations")
    @Produces(MediaType.APPLICATION_JSON)
    @Query("getAllReservations")
    public List<Reservation> getAllReservations(){
        return reservationRepository.getAllReservations();
    }
}
