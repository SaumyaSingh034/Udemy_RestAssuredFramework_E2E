package RequestSpecification;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class BaseSetUp {

    @BeforeTest
    public void setUp(){
        RestAssured.baseURI="https://rahulshettyacademy.com";
    }
}
