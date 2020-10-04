package petStoreTestApi;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import models.PetResponse;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class GetPet {
    @Test
    public void getPetById_PetReturned(){
        Response response = given()
                .baseUri("https://petstore.swagger.io/v2")
                .basePath("/pet/1000")
                .when()
                .get()
                .then()
                .statusCode(200)
                .extract()
                .response();
//        String body = response.asString();
//        Assert.assertTrue(body.contains("NutCracker"));
        JsonPath body = response.jsonPath();
//        System.out.println(body.prettify());
        PetResponse hamster = body.getObject("$", PetResponse.class);

        Assert.assertEquals(hamster.getName(),"doggie");
        Assert.assertEquals(hamster.getStatus(),"available");
        Assert.assertEquals(hamster.getId(),1000);
        Assert.assertEquals(hamster.getCategory().getName(),"kQZh3WP8AG_-wUd8");
        Assert.assertEquals(hamster.getCategory().getId(),746);



    }
}
