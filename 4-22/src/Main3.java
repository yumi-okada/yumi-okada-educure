import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class Main3 {
    public static void main(String[] args) {
        try {
            JAXBContext context = JAXBContext.newInstance(Book.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            Book book = (Book) unmarshaller.unmarshal(new File("excersise.xml"));

            System.out.println("タイトル: " + book.getTitle());
            System.out.println("著者: " + book.getAuthor());
            System.out.println("価格: " + book.getPrice());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
