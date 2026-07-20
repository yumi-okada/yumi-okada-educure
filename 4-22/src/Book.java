import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlRootElement(name = "book")
@XmlAccessorType(XmlAccessType.FIELD)

public class Book {
    private String title;
        private String author;
        private int price;

        public String getTitle() { return title; }
        public String getAuthor() { return author; }
        public int getPrice() { return price; }

        public Book() {}
}
