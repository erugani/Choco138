package apitest;

import com.google.gson.Gson;
import entities.AccountEntity;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class Account {

    String userId;
    String ct = "application/json";
    String jsonBody;
    String uri = "https://bookstore.toolsqa.com/Account/v1/";
    Response resposta;
    String token;
    Gson gson = new Gson();
    AccountEntity account = new AccountEntity();


    @Test (priority = 1)
        public void testCreateUser (){

        account.userName = "charlie080";  //userID 2acb1634-452b-447d-a229-13aaeaf45539
        account.password = "P@ss0rd1";

        jsonBody = gson.toJson(account);

        resposta = (Response) given()
                .contentType(ct)
                .log().all()
                .body(jsonBody)

        .when()
                .post(uri + "User")

        .then()
                .log().all()
                .statusCode(201)
                .body("username", is(account.userName))
                .extract()
        ;

        userId = resposta.jsonPath().getString("userID");
        System.out.println("UserID extraido: " + userId);


    }
    @Test (priority = 2)
    public void testGenerateToken(){

        resposta = (Response) given()
                .contentType(ct)
                .log().all()
                .body(jsonBody)

        .when()
                .post(uri + "GenerateToken")

        .then()
                .log().all()
                .statusCode(200)
                .body("status", is ("Success"))
                .body("result", is ("User authorized successfully."))

        .extract()
        ;

        token  = resposta.jsonPath().getString("token");
        System.out.println("token: " + token);

        Assert.assertTrue(token.length() != 0);

    }

    @Test (priority = 3)
    public void testAuthorized (){
        given()
                .contentType(ct)
                .log().all()
                .body(jsonBody)
        .when()
                .post(uri + "Authorized")
        .then()
                .log().all()
                .statusCode(200)
                //.body(true)
                ;

    }

    @Test (priority  = 4)
    public void testResearchUserNotAuthorized(){

        given()
                .contentType(ct)
                .log().all()

        .when()
                .get(uri + "User/" + userId)
        .then()
                .log().all()
                .statusCode(401)
                .body("code", is("1200"))
                .body("message", is("User not authorized!"))
                ;


    }
    @Test (priority  = 5)
    public void testResearchUser(){

        given()
                .contentType(ct)
                .log().all()
                .header("Authorization", "Bearer " + token)
        .when()
                .get(uri + "User/" + userId)
        .then()
                .log().all()
                .statusCode(200)
                .body("userId", is (userId))
                .body("username", is(account.userName))
        ;


    }
}
