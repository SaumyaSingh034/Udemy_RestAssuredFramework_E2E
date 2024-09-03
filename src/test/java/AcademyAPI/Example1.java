package AcademyAPI;

import Payload.PostRequestPayload;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Example1 {

    public String placeId;

    @Test
    public void creatingPostRequest(){
        RestAssured.baseURI="https://rahulshettyacademy.com";

        Response response = given().log().all().queryParam("key", "qaclick123")
                .header("Content-Type","application/json")
                .body(PostRequestPayload.createData())
                .when()
                .post("maps/api/place/add/json")
                .then()
                .assertThat()
                .log()
                .all()
                .statusCode(200).body("scope",equalTo("APP"))
                .extract()
                .response();
       placeId = response.jsonPath().get("place_id");
    }

    @Test
    public void updateNewAddress(){

    }


}
