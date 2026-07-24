import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main2 {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("apple", "banana", "cherry");
       
        List<String> upperList = words.stream()
                                      .map(s -> s.toUpperCase())
                                      .collect(Collectors.toList());
        System.out.println(upperList);
    }
}
