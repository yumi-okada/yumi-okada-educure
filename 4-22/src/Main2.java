import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Main2 {
    public static void main(String[] args) {
        String filePath = "excersise.properties";

        // Properties オブジェクトを作成
        Properties properties = new Properties();

        try (FileInputStream input = new FileInputStream(filePath)) {
        properties.load(input);
        System.out.println("username=" + properties.getProperty("username"));
        System.out.println("password=" + properties.getProperty("password"));
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
