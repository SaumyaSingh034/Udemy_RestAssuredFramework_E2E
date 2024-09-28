package DeserializationPOJO;

public class POJO1 {

        /*
    Serialization Converting Java Object to JSON(Request Payload)
     */

    private String message;

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    private String display;



    public String getMessage(){
        return message;
    }

}
