package at.htl.restrauntmanagement.boundary;

import at.htl.restrauntmanagement.control.CustomerRepository;
import at.htl.restrauntmanagement.control.ReservationRepository;
import at.htl.restrauntmanagement.control.TableRepository;
import at.htl.restrauntmanagement.entity.Customer;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.xml.transform.Templates;

import at.htl.restrauntmanagement.entity.Reservation;
import at.htl.restrauntmanagement.entity.Table;
import io.quarkus.example.Greeter;
import io.quarkus.example.HelloRequest;
import io.quarkus.grpc.GrpcClient;
import io.quarkus.qute.CheckedTemplate;
import io.quarkus.qute.TemplateInstance;
import io.smallrye.mutiny.Uni;
import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Mutation;
import org.eclipse.microprofile.graphql.Query;

import java.util.List;

@GraphQLApi
@Path("/customer")
public class CustomerResource {

    @GrpcClient
    Greeter hello;

    @Inject
    CustomerRepository customerRepository;

    @Inject
    TableRepository tableRepository;

    @Inject
    ReservationRepository reservationRepository;

    @CheckedTemplate
    public static class Templates {
        public static native TemplateInstance customers(Customer customer);
        public static native TemplateInstance tables(Table table);
        public static native TemplateInstance reservations(Reservation reservation);
    }

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

    @GET
    @Produces(MediaType.TEXT_HTML)
    @Path("/html/customer/{id}")
    public TemplateInstance getCustomerHTML(@PathParam("id") Long id) {
        return Templates.customers(customerRepository.findById(id));
    }

    @GET
    @Produces(MediaType.TEXT_HTML)
    @Path("/html/table/{id}")
    public TemplateInstance getTableHTML(@PathParam("id") Long id) {
        return Templates.tables(tableRepository.findById(id));
    }

    @GET
    @Produces(MediaType.TEXT_HTML)
    @Path("/html/reservation/{id}")
    public TemplateInstance getReservationHTML(@PathParam("id") Long id) {
        return Templates.reservations(reservationRepository.findById(id));
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/greet/{name}")
    public Uni<String> greetCustomer(@PathParam("name") String name){
        return hello.sayHello(HelloRequest.newBuilder().setName(name).build())
                .onItem().transform(helloReply -> helloReply.getMessage());
    }


}
