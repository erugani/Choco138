package apitest;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class BookStore {

    String uri = "https://bookstore.toolsqa.com/BookStore/v1/";
    String ct = "application/json"/
@Test (priority = 1)
    public void testResearchBooks(){

    given()
            .log().all()
            .contentType(ct)
            .header("Authentication", "Bearer " + Account.token)

}

}
