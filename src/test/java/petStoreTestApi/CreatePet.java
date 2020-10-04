package petStoreTestApi;

import helper.TestDataGenerator;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import models.Category;
import models.PetRequest;
import models.PetResponse;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class CreatePet {
    private long petId;
    @AfterMethod
    public void terDown(){
        given().baseUri("https://petstore.swagger.io/v2/pet/"+petId).when().delete();
        // same code
//                .basePath("/pet/"+petId)
//                .when()
//                .delete();

    }


    @Test
    public void createPet(){
        PetRequest petRequest = TestDataGenerator.getpet();
        Response response = given()
                .baseUri("https://petstore.swagger.io/v2")
                .basePath("/pet")
                .header("Content-Type","application/json")
                .body(petRequest)
                .when()
                .post()
                .then()
                .statusCode(200)
                .extract()
                .response();
        JsonPath jsonpath = response.jsonPath();
        // $ means all object
        PetResponse petResponse = jsonpath.getObject("$",PetResponse.class);
        //System.out.println(petResponse.getId());
        petId = petResponse.getId();
        Assert.assertEquals(petRequest.getStatus(),petResponse.getStatus());
        Assert.assertEquals(petRequest.getName(),petResponse.getName());
        Assert.assertEquals(petRequest.getCategory().getName(),petResponse.getCategory().getName());


        // By selected object
        // Example 1
//        Category categoryResponse = jsonpath.getObject("category",Category.class);
//        System.out.println(categoryResponse.getName());

        // Example 2
//        String petstatusResponse = jsonpath.getString("status");
//        System.out.println(petstatusResponse);

        // Example 3
//        long id = jsonpath.getLong("id");
//        System.out.println(id);



    }
}
