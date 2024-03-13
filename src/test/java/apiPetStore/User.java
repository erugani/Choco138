package apiPetStore;

import com.google.gson.Gson;
import entities.UserEntity;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class User {
    String jsonBody;
    Gson gson = new Gson();
    String ct = "application/json";

    String uri = "https://petstore.swagger.io/v2/";

    @Test
    public void testCreateUser(){
        UserEntity user = new UserEntity();
        user.id = 9999;
        user.username = "charlie";
        user.firstName = "charlie";
        user.lastName = "brown";
        user.email = "charlie@iterasys.com.br";
        user.password = "123456";
        user.phone = "5511978456321";
        user.userStatus = 0;

        jsonBody = gson.toJson(user);

        int code =200;
        String type = "unknown";
        String message = "9999";

        given()
                .contentType(ct)
                .log().all()
                .body(jsonBody)
        .when()
                .post(uri + "user")
        .then()
                .log().all()
                .statusCode(200)
                .body("code", is(code))
                .body("type", is(type))
                .body("message", is(message))
        ;
                




    }
}
