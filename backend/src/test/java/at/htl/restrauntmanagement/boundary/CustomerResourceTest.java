package at.htl.restrauntmanagement.boundary;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.startsWith;
import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
class CustomerResourceTest {

    @Test
    void getAllCustomers(){
        when()
                .get("customer/all")
                .then()
                .statusCode(200)
                .body(startsWith("[{"));
    }
}