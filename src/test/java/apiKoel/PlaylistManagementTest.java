package apiKoel;

import helper.TestDataGenerator;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import models.Playlist;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class PlaylistManagementTest {
    private int playlistId;
    @AfterMethod
    public void tearDown(){
        Response response = given()
                .baseUri("https://koelapp.testpro.io/")
                .basePath("api/playlist")
                .header("Content-Type","application/json")
                .header("Authorization","Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOjM3LCJpc3MiOiJodHRwczovL2tvZWxhcHAudGVzdHByby5pby9hcGkvbWUiLCJpYXQiOjE2MDIxMTA0NjAsImV4cCI6MTYwMjcxNTI2MCwibmJmIjoxNjAyMTEwNDYwLCJqdGkiOiJrcTNUSVdpWTdNVWJCRjdCIn0.X9PQNYh3S3Nyg5BuvCL4ohxkWoxSlLXkK4FCPtn5WlM")
                .body(createPlaylist)
                .when()
                .post()
                .then()
                .statusCode(200)
                .extract()
                .response();
    }
    @Test
    public void createPlaylist_PlaylistCreated(){
        Playlist createPlaylist = TestDataGenerator.createPlaylistRequest();
        Response response = given()
                .baseUri("https://koelapp.testpro.io/")
                .basePath("api/playlist")
                .header("Content-Type","application/json")
                .header("Authorization","Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOjM3LCJpc3MiOiJodHRwczovL2tvZWxhcHAudGVzdHByby5pby9hcGkvbWUiLCJpYXQiOjE2MDIxMTA0NjAsImV4cCI6MTYwMjcxNTI2MCwibmJmIjoxNjAyMTEwNDYwLCJqdGkiOiJrcTNUSVdpWTdNVWJCRjdCIn0.X9PQNYh3S3Nyg5BuvCL4ohxkWoxSlLXkK4FCPtn5WlM")
                .body(createPlaylist)
                .when()
                .post()
                .then()
                .statusCode(200)
                .extract()
                .response();
        JsonPath jsonpath = response.jsonPath();
        Playlist responsePlaylist = jsonpath.getObject("$",Playlist.class);
        Assert.assertEquals(createPlaylist.getName(),responsePlaylist.getName());
        playlistId=responsePlaylist.getId();
    }
}
