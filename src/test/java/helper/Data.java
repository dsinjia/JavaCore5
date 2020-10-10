package helper;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import models.Token;

import static io.restassured.RestAssured.given;

public class Data {
    public static models.Data get(){
        String token = TokenHelper.get();
        var response = given()
                .baseUri("https://koelapp.testpro.io/")
                .basePath("api/data")
                .header("Authorization","BEARER "+token)
                .when()
                .get()
                .then()
                .statusCode(200)
                .extract()
                .response();
        JsonPath jsonpath = response.jsonPath();
        return jsonpath.getObject("$", models.Data.class);
    }
}
