package at.htl.restrauntmanagement.boundary;

import at.htl.restrauntmanagement.entity.Customer;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.Validate;

import javax.validation.Valid;

import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.startsWith;
import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
class CustomerResourceTest {

    @Test
    void getAllCustomers(){
        when()
                .get("customer/allCustomer")
                .then()
                .statusCode(200)
                .body(startsWith("[{"));
    }

    @Test
    void getAllTables() {
        when()
                .get("customer/allTables")
                .then()
                .statusCode(200)
                .body(startsWith("{["));
    }

    @Test
    void getAllReservations() {
        when()
                .get("customer/allReservations")
                .then()
                .statusCode(200)
                .body(startsWith("{["));
    }
}