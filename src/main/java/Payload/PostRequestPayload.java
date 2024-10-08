package Payload;

public class PostRequestPayload {
    public static String addBook(){
        return "{\"name\":\"LearnAppiumAutomationwithJava\",\"isbn\":\"bcd\",\"aisle\":\"227\",\"author\":\"Johnfoe\"}";
    }

    public static String addBookWithParams(String name, String isbn, String aisle, String author){
        return "{\"name\":\""+name+"\",\"isbn\":\""+isbn+"\",\"aisle\":\""+aisle+"\",\"author\":\""+author+"\"}";
    }

    public static String createData(){
        return "{\"location\":{\"lat\":-38.383494,\"lng\":33.427362},\"accuracy\":50,\"name\":\"Frontlinehouse\",\"phone_number\":\"(+91)9838933937\",\"address\":\"29,sidelayout,cohen09\",\"types\":[\"shoepark\",\"shop\"],\"website\":\"http://google.com\",\"language\":\"French-IN\"}";
    }

    public static String complexJsonRahul(){
         return "{\r\n" +
                "  \"dashboard\": {\r\n" +
                "    \"purchaseAmount\": 1162,\r\n" +
                "    \"website\": \"rahulshettyacademy.com\"\r\n" +
                "  },\r\n" +
                "  \"courses\": [\r\n" +
                "    {\r\n" +
                "      \"title\": \"Selenium Python\",\r\n" +
                "      \"price\": 50,\r\n" +
                "      \"copies\": 6\r\n" +
                "    },\r\n" +
                "    {\r\n" +
                "      \"title\": \"Cypress\",\r\n" +
                "      \"price\": 40,\r\n" +
                "      \"copies\": 4\r\n" +
                "    },\r\n" +
                "    {\r\n" +
                "      \"title\": \"RPA\",\r\n" +
                "      \"price\": 45,\r\n" +
                "      \"copies\": 10\r\n" +
                "    },\r\n" +
                "     {\r\n" +
                "      \"title\": \"Appium\",\r\n" +
                "      \"price\": 36,\r\n" +
                "      \"copies\": 7\r\n" +
                "    }\r\n" +
                "    \r\n" +
                "    \r\n" +
                "    \r\n" +
                "  ]\r\n" +
                "}\r\n" +
                "";


    }

    public static  String complexJsonAnuj() {
        return "{\"store\":{\"book\":[{\"category\":\"reference\",\"author\":\"NigelRees\",\"title\":\"SayingsoftheCentury\",\"price\":8.95},{\"category\":\"fiction\",\"author\":\"EvelynWaugh\",\"title\":\"SwordofHonour\",\"price\":12.99},{\"category\":\"fiction\",\"author\":\"HermanMelville\",\"title\":\"MobyDick\",\"isbn\":\"0-553-21311-3\",\"price\":8.99},{\"category\":\"fiction\",\"author\":\"J.R.R.Tolkien\",\"title\":\"TheLordoftheRings\",\"isbn\":\"0-395-19395-8\",\"price\":22.99}],\"bicycle\":{\"color\":\"red\",\"price\":19.95}},\"expensive\":10}";
    }
}
