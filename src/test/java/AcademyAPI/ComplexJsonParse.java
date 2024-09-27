package AcademyAPI;

import Payload.PostRequestPayload;
import io.restassured.path.json.JsonPath;

public class ComplexJsonParse {
    public static void main(String[] args){
        JsonPath jsRahul = new JsonPath(PostRequestPayload.complexJsonRahul());


        /*




        3.



        5. Print no of copies sold by RPA Course

        6. Verify if Sum of all Course prices matches with Purchase Amount
         */

        // 1. Print No of courses returned by API
        int size =  jsRahul.get("courses.size()");
        System.out.println(size);

        //2.Print Purchase Amount
        System.out.println(jsRahul.getInt("dashboard.purchaseAmount"));

        //3. Print Title of the first course
        System.out.println(jsRahul.getString("courses[0].title"));

        //4. Print All course titles and their respective Prices
        for(int i=0;i<size;i++){
            String title = jsRahul.get("courses["+i+"].title");
            int prices = jsRahul.getInt("courses["+i+"].price");
           System.out.println(title+" ---> " +prices);
        }











        JsonPath jsAnuj = new JsonPath(PostRequestPayload.complexJsonAnuj());
        System.out.println("****************** ");
        int sizeA = jsAnuj.getInt("store.book.size()");
        System.out.println(sizeA);
        String title;

        for(int i=0;i<sizeA;i++){
            title = jsAnuj.getString("store.book["+i+"].title");
            if(title.equalsIgnoreCase("MobyDick")) {
                String isbn = jsAnuj.getString("store.book[" + i + "].isbn");
                System.out.println(isbn);
            }

        }

    }
}
