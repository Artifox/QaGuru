package lesson20_restapi_specs;

import lesson20_restapi_specs.models.login.login_request.Login;
import lesson20_restapi_specs.models.user.user_request.User;
import lesson20_restapi_specs.models.user.user_response.UserResponse;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static lesson20_restapi_specs.specs.LoginSpecs.loginRequestSpec;
import static lesson20_restapi_specs.specs.LoginSpecs.unsuccessfulLoginResponseSpec;
import static lesson20_restapi_specs.specs.UserSpecs.userResponseSpec;
import static lesson20_restapi_specs.specs.UserSpecs.userRequestSpec;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.blankOrNullString;
import static org.hamcrest.Matchers.hasKey;

public class RestAssuredTest {

    @Test
    public void whenGetSingleUserById_thenDataArrayShouldContainUserId() {
        User user = new User();
        user.setId(2);
        UserResponse response = given()
                .spec(userRequestSpec)
                .pathParam("id", user.getId())
                .when()
                .get("/{id}")
                .then()
                .spec(userResponseSpec)
                .extract().as(UserResponse.class);
        assertThat(response.getData().getId()).isEqualTo(2);
    }

    @Test
    public void giveUser_whenCreateNewUser_thenUserCreatedWithId() {
        User user = new User();
        user.setLastName("morpheus");
        user.setJob("leader");
        User createdUser = given()
                .spec(userRequestSpec)
                .body(user)
                .when()
                .post()
                .then()
                .log().all()
                .extract().as(User.class);
        assertThat(createdUser.getLastName()).isEqualTo(user.getLastName());
    }

    @Test
    public void giveUserId_whenDeleteUserById_thenUserDeleted() {
        User user = new User();
        user.setId(2);
        given()
                .spec(userRequestSpec)
                .pathParam("id", user.getId())
                .when()
                .delete("/{id}")
                .then()
                .log().all()
                .statusCode(204)
                .assertThat()
                .body(blankOrNullString());
    }

    @Test
    public void givenUserEmail_whenLoginWithoutPassword_thenError400() {
        Login login = new Login();
        login.setEmail("myem@mail.io");
        given()
                .spec(loginRequestSpec)
                .body(login)
                .when()
                .post("/login")
                .then()
                .spec(unsuccessfulLoginResponseSpec)
                .assertThat()
                .body("error", is("Missing password"));
    }

    @Test
    public void giveUserId_whenUpdateUserById_thenUserUpdated() {
        User user = new User();
        user.setId(2);
        given()
                .spec(userRequestSpec)
                .pathParam("id", user.getId())
                .when()
                .put("/{id}")
                .then()
                .assertThat()
                .body("$", hasKey("updatedAt"));
    }
}
