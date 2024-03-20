package apitest;

import entities.LoanEntity;
import org.testng.annotations.*;
import com.google.gson.Gson;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

import org.testng.ITestContext;

public class TestBookStore {

    String uri = "https://bookstore.toolsqa.com/BookStore/v1/";
    String ct = "application/json";
    TestAccount account = new TestAccount();
    Gson gson = new Gson();
    LoanEntity isbn = new LoanEntity();
@BeforeClass
//@BeforeMethod
public void setUp(ITestContext context){
    account.testCreateUser(context);
    account.testGenerateToken(context);
}
@AfterClass
//@AfterMethod
public void tearDown(){
    account.testDeleteUser();
}

@Test (priority = 1)
public void testResearchBooks(ITestContext context){

    given()
            .log().all()
            .contentType(ct)
            .header("Authentication", "Bearer " + context.getAttribute("token"))
    .when()
            .get(uri + "Books")
    .then()
            .log().all()
            .statusCode(200)
    ;


    }

@Test(priority = 2)
public void testLoanBooks(ITestContext context){
    isbn.userId = context.getAttribute("userID").toString();
    isbn.collectionOfIsbns = new LoanEntity.ISBN[] {
            new LoanEntity.ISBN("9781449325862")
    };
    //isbn.isbn = "978144932862";

    given()
            .log().all()
            .contentType(ct)
            .header("Authorization", "Bearer " + context.getAttribute("token"))
            .body(gson.toJson(isbn))
    .when()
            .post(uri + "Books")
    .then()
            .log().all()
            .statusCode(201)
            .body("isbn", is(isbn.isbn))
    ;

    }
@Test(priority = 3)
public void testUpdateLoan(ITestContext context){
     String isbnAntigo = "9781449325862";
     String isbnNovo = "9781449331818";

     isbn = new LoanEntity();
     isbn.userId = context.getAttribute("userID").toString();
     isbn.isbn = isbnNovo;


    given()
            .log().all()
            .contentType(ct)
            .header("Authorization", "Bearer " + context.getAttribute("token"))
            .body(gson.toJson(isbn))
    .when()
            .put(uri + "Books/" + isbnAntigo)
    .then()
            .log().all()
            .statusCode(200)
            .body("books[0].isbn", is(isbnNovo))
            ;






    }

}
