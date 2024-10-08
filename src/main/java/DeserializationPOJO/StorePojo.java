package DeserializationPOJO;

import java.util.ArrayList;

public class StorePojo {
    public ArrayList<Book> book;
  private Bicycle bicycle;

    public ArrayList<Book> getBook() {
        return book;
    }

    public void setBook(ArrayList<Book> book) {
        this.book = book;
    }

    public Bicycle getBicycle() {
        return bicycle;
    }

    public void setBicycle(Bicycle bicycle) {
        this.bicycle = bicycle;
    }
}
