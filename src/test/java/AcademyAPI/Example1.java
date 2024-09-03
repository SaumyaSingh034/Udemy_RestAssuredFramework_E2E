package AcademyAPI;

import Payload.PostRequestPayload;
import RequestSpecification.BaseSetUp;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Example1 extends BaseSetUp {

    public String placeId;
    Response response;


    @Test(priority = 0)
    public void creatingPostRequest(){

        response = given().log().all().queryParam("key", "qaclick123")
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

    @Test(priority = 1)
    public void updateNewAddress(){
        response = given().log().all().header("Content-Type","application/json")
                .queryParam("key","qaclick123")
                .body("{\"place_id\":\""+placeId+"\",\"address\":\"UpdatedAddress_Saumya,USA\",\"key\":\"qaclick123\"}")
                .when()
                .put(" /maps/api/place/update/json")
                .then()
                .assertThat()
                .statusCode(200).log().all().extract().response();
        String msg = response.jsonPath().get("msg");
        Assert.assertEquals(msg,"Address successfully updated");
    }

    @Test(priority = 2)
    public void getData(){
        response = given().log().all()
                .header("Content-Type", "application/json")
                .queryParam("place_id",placeId)
                .when()
                .get("/maps/api/place/get/json")
                .then()
                .statusCode(200).log().all()
                .extract()
                .response();

    }


}
