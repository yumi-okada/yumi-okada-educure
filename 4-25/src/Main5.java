import java.util.function.Function;
import java.util.function.Predicate;

public class Main5 {
    public static void main(String[] args) {
        
        Function<Integer, Integer> multiplyByTwo = x -> x * 2;
        Function<Integer, Integer> subtractFive = x -> x - 5;
        Predicate<Integer> isPositive = x -> x > 0;

        Function<Integer, Integer> combined = multiplyByTwo.andThen(subtractFive);

        int result = combined.apply(8);
        
        if (isPositive.test(result)) {
            System.out.println("正の数です");            
        } else {
            System.out.println("負の数またはゼロです");
        }
    }
}
