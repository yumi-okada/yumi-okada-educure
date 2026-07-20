import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import com.google.gson.Gson;

public class Main4 {
    public static void main(String[] args) {
        try {
            String json = Files.readString(Paths.get("excersise.json"));

            Gson gson = new Gson();

            Employee employee = gson.fromJson(json, Employee.class);

            System.out.println("Name: " + employee.getName());
            System.out.println("Age: " + employee.getAge());
            System.out.println("Salary: " + (int)employee.getSalary());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
