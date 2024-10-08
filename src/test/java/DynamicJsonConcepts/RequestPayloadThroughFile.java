package DynamicJsonConcepts;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static io.restassured.RestAssured.given;

public class RequestPayloadThroughFile {

    private static String readFromFile(){
        try {
            return new String (Files.readAllBytes(Path.of("src/main/java/Payload/payload.json")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void sendRequestBodyFromFile(){
        RestAssured.baseURI = "http://216.10.245.166";
        given()
                .header("content-type","application/json")
                .body(readFromFile())
                .log()
                .all()
                .when()
                .post("/Library/Addbook.php")
                .then()
                .statusCode(200).log().all();
    }
}
