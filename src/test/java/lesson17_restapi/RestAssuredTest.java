package lesson17_restapi;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.blankOrNullString;
import static org.hamcrest.Matchers.hasKey;

public class RestAssuredTest {

    @Test
    public void whenGetSingleUserById_thenDataArrayShouldContainUserId(){
        Integer userId = 2;
        given()
                .pathParam("id", userId)
        .when()
                .get("https://reqres.in/api/users/{id}")
        .then()
                .log().all()
                .statusCode(200)
                .assertThat()
                .body("data.id", equalTo(userId));

    }

    @Test
    public void giveUser_whenCreateNewUser_thenUserCreatedWithId(){
        String user = "{\n" +
                "    \"name\": \"morpheus\",\n" +
                "    \"job\": \"leader\"\n" +
                "}";
        given()
                .body(user)
        .when()
                .post("https://reqres.in/api/users")
        .then()
                .log().all()
                .statusCode(201)
                .assertThat()
                .body("name", equalTo("morpheus"));
    }

    @Test
    public void giveUserId_whenDeleteUserById_thenUserDeleted(){
        Integer userId = 2;
        given()
                .pathParam("id",userId)
        .when()
                .delete("https://reqres.in/api/users/{id}")
        .then()
                .log().all()
                .statusCode(204)
                .assertThat()
                .body(blankOrNullString());
    }

    @Test
    public void givenUserEmail_whenLoginWithoutPassword_thenError400(){
        String credentialsWithoutPassword = "{\n" +
                "    \"email\": \"peter@klaven\"\n" +
                "}";
        given()
                .body(credentialsWithoutPassword)
        .when()
                .post("https://reqres.in/api/login")
        .then()
                .log().all()
                .statusCode(400)
                .assertThat()
                .body("error", is("Missing email or username"));
    }

    @Test
    public void giveUserId_whenUpdateUserById_thenUserUpdated(){
        Integer userId = 2;
        given()
                .pathParam("id",userId)
        .when()
                .put("https://reqres.in/api/users/{id}")
        .then()
                .log().all()
                .statusCode(200)
                .assertThat()
                .body("$", hasKey("updatedAt"));
    }
}
