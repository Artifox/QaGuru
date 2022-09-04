package lesson20_restapi_specs.specs;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.with;
import static org.hamcrest.core.IsNull.notNullValue;

public class LoginSpecs {

    public static RequestSpecification loginRequestSpec = with()
            .baseUri("https://reqres.in")
            .basePath("/api")
            .filter(new AllureRestAssured())
            .log().all()
            .contentType(ContentType.JSON);

    public static ResponseSpecification unsuccessfulLoginResponseSpec = new ResponseSpecBuilder()
            .expectStatusCode(400)
            .log(LogDetail.ALL)
            .expectBody("error", notNullValue())
            .build();
}
