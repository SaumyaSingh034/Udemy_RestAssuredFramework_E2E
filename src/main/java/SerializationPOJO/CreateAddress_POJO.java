package SerializationPOJO;

import java.util.List;

public class CreateAddress_POJO {

    private Location location;
    private String accuracy;
    private String name;
    private String phone_number;
    private String address;
    private String website;

    public void setLocation(Location location) {
        this.location = location;
    }

    public void setAccuracy(String accuracy) {
        this.accuracy = accuracy;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setTypes(List<String> types) {
        this.types = types;
    }

    private String language;
    private List<String> types;

}
