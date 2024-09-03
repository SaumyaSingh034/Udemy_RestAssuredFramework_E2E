package AcademyAPI;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class TestJson {

    @Test
    public void printBelowAllJson(){
        String response = "{\"dashboard\":{\"purchaseAmount\":910,\"website\":\"rahulshettyacademy.com\"}," +
                "\"courses\":[{\"title\":\"SeleniumPython\",\"price\":50,\"copies\":6}," +
                "{\"title\":\"Cypress\",\"price\":40,\"copies\":4},{\"title\":\"RPA\"," +
                "\"price\":45,\"copies\":10}]}";
        JsonPath js = new JsonPath(response);
        //        1. Print No of courses returned by API
      ArrayList<String> s =   js.get("courses.title");
     System.out.println(s);
        //        2.Print Purchase Amount
        Integer purchaseAmount = js.get("dashboard.purchaseAmount");
        System.out.println(purchaseAmount);
        //        3. Print Title of the first course
        String title = js.get("courses.title[0]");
        System.out.println(title);
        //        4. Print All course titles and their respective Prices
        int size = js.get("courses.size()");
        int sum = 0;
        for(int i=0;i<size;i++){
            String title1 = js.get("courses.title["+i+"]");
            int price = js.get("courses.price["+i+"]");
            sum = sum + price;

            System.out.println(title1+" ----> "+price);

            //  5. Print no of copies sold by RPA Course
            if(title1.equals("RPA")){
               int copy = js.get("courses.copies["+i+"]");
               System.out.println(copy);
            }

        }

        //        6. Verify if Sum of all Course prices matches with Purchase Amount
        System.out.println("Sum of All courses : "+sum);
        if(sum==purchaseAmount){
            System.out.println("Both are same");
        } else{
            System.out.println("Different");
        }


    }
}
