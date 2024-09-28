package SerializationConcept;

import DeserializationPOJO.POJO1;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class ConvertingJavaObject {

    POJO1 pojo = new POJO1();
    @Test
    public void serializationConcept(){
        pojo.setMessage("Hello This is Saumya Messgae");
        pojo.setDisplay("Hello Saumya Display");

        given().log().all()
                .body(pojo)
                .when()
                .post("/")
                .then()
                .statusCode(200);

    }
}
