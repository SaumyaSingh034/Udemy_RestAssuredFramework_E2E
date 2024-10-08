package DynamicJsonConcepts;

import Payload.PostRequestPayload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class DynamicJson1 {

    @Test
    public void dynamicJson(){
        RestAssured.baseURI = "http://216.10.245.166";

        Response response = given().header("content-type","application/json")
                .body(PostRequestPayload.addBook())
                .log()
                .all()
                .when()
                .post("/Library/Addbook.php")
                .then()
                .statusCode(200)
                .log().all().body("Msg",equalTo("successfully added")).
                extract().response();

        JsonPath js = new JsonPath(response.toString());
        String mesage = js.get("Msg");
        String id = js.get("ID");
        System.out.println(mesage+"     "+id);
    }

    @DataProvider(name="testDataSet")
    public Object[][] setUpData(){
        return new Object[][] {
                {"Learn Selenium", "afdd", "8977", "Saumya"},
                {"Learn Rest Assured", "hjja", "98881", "Rahul"},
                {"Learn Mobile", "hdhd", "98797", "Naveen"}
        };
    }

    @Test(dataProvider = "testDataSet")
    public void addBook(String name, String isbn, String aisle, String author){
        RestAssured.baseURI = "http://216.10.245.166";
        Response response = given().header("content-type","application/json")
                .body(PostRequestPayload.addBookWithParams(name, isbn, aisle, author))
                .when().post("/Library/Addbook.php")
                .then().statusCode(200).log().all()
                .body("Msg",equalTo("successfully added"))
                .extract().response();
        String is = response.jsonPath().get("ID");
        System.out.println("******* ID ********* "+is);
    }

}
