package AcademyAPI;

import Payload.PostRequestPayload;
import RequestSpecification.BaseSetUp;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class PracticeNestedResponse extends BaseSetUp {

    @Test
    public void getCallAndValidate(){
       Response response =  given().queryParam("key","qaclick123")
                .header("Content-Type","application/json")
                .body(PostRequestPayload.createData())
                .when()
                .post("maps/api/place/add/json")
                .then()
                .log()
                .all()
                .statusCode(200)
               .header("Server","Apache/2.4.52 (Ubuntu)").extract()
                .response();

       String placeIdFromResponse1;
       String placeIdFromResponse2;
        placeIdFromResponse1 = response.jsonPath().get("place_id");
        JsonPath json = new JsonPath(response.asString());
        placeIdFromResponse2 = json.getString("place_id");
        System.out.println(placeIdFromResponse1);
        System.out.println(placeIdFromResponse2);

        given().queryParam("key","qaclick123")
                .header("Content-Type","application/json")
                .body("{\"place_id\":\""+placeIdFromResponse1+"\",\"address\":\"updatedAddress\",\"key\":\"qaclick123\"}")
                .when()
                .put("maps/api/place/update/json")
                .then()
                .log()
                .all()
                .statusCode(200)
                .body("msg",equalTo("Address successfully updated"));
    }


}
