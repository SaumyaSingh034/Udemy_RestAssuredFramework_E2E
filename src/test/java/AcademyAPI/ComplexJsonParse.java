package AcademyAPI;

import DeserializationPOJO.Root;
import DeserializationPOJO.StorePojo;
import Payload.PostRequestPayload;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;

public class ComplexJsonParse {
    @Test
    public void usingJsonPath() {
        JsonPath jsRahul = new JsonPath(PostRequestPayload.complexJsonRahul());

        // 1. Print No of courses returned by API
        int size = jsRahul.get("courses.size()");
        System.out.println(size);

        //2.Print Purchase Amount
        System.out.println(jsRahul.getInt("dashboard.purchaseAmount"));

        //3. Print Title of the first course
        System.out.println(jsRahul.getString("courses[0].title"));

        //4. Print All course titles and their respective Prices
        for (int i = 0; i < size; i++) {
            String title = jsRahul.get("courses[" + i + "].title");
            int prices = jsRahul.getInt("courses[" + i + "].price");
            System.out.println(title + " ---> " + prices);
        }
        //5.. Print no of copies sold by RPA Course
        for (int i = 0; i < size; i++) {
            if (jsRahul.getString("courses[" + i + "].title").equalsIgnoreCase("RPA")) {
                System.out.println(jsRahul.getInt("courses[" + i + "].copies"));
            }
        }
        //6.Verify if Sum of all Course prices matches with Purchase Amount
        int sum = 0;
        int purchaseAmount = jsRahul.get("dashboard.purchaseAmount");
        for (int i = 0; i < size; i++) {
            sum += jsRahul.getInt("courses[" + i + "].price");
            break;
        }
        if (sum == purchaseAmount)
            System.out.println("Both Amounts are same");
        else
            System.out.println("Amounts are different");


        JsonPath jsAnuj = new JsonPath(PostRequestPayload.complexJsonAnuj());
        System.out.println("****************** ");
        int sizeA = jsAnuj.getInt("store.book.size()");
        System.out.println(sizeA);
        String title;

        for (int i = 0; i < sizeA; i++) {
            title = jsAnuj.getString("store.book[" + i + "].title");
            if (title.equalsIgnoreCase("MobyDick")) {
                String isbn = jsAnuj.getString("store.book[" + i + "].isbn");
                System.out.println(isbn);
            }

        }

        int expensive = jsAnuj.getInt("expensive");
        System.out.println(expensive);

    }

    @Test
    public void usingPOJOClass(){
        String response = PostRequestPayload.complexJsonAnuj();
     /*   StorePojo sp = response.as(StorePojo.class);
*/

        ObjectMapper obj = new ObjectMapper();
        try {
            Root root = obj.readValue(response, Root.class);
            System.out.println(root.getExpensive()+" Expensive");
            System.out.println(root.getStore().getBicycle().getColor()+" -----> "+root.getStore().getBicycle().getPrice());
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
