package lesson20_restapi_specs.specs;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.with;
import static org.hamcrest.core.IsNull.notNullValue;

public class UserSpecs {

    public static RequestSpecification userRequestSpec = with()
            .baseUri("https://reqres.in")
            .basePath("/api/users")
            .filter(new AllureRestAssured())
            .log().all()
            .contentType(ContentType.JSON);

    public static ResponseSpecification userResponseSpec = new ResponseSpecBuilder()
            .expectStatusCode(200)
            .log(LogDetail.ALL)
            .expectBody("data", notNullValue())
            .build();
}
