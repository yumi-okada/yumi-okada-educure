import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class Main3 {
    public static void main(String[] args) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            DocumentBuilder builder = factory.newDocumentBuilder();

            Document document = builder.parse("excersise.xml");
            NodeList titleNode = document.getElementsByTagName("title");
            NodeList authorNode = document.getElementsByTagName("author");
            NodeList priceNode = document.getElementsByTagName("price");

            String title = titleNode.item(0).getTextContent();
            String author = authorNode.item(0).getTextContent();
            int price = Integer.parseInt(priceNode.item(0).getTextContent());

            Book book = new Book(title, author, price);

            System.out.println("タイトル: " + book.getTitle());
            System.out.println("著者: " + book.getAuthor());
            System.out.println("価格: " + book.getPrice());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
