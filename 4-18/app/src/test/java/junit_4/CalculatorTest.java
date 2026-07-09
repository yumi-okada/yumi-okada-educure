package junit_4;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
    @Test
    void testAdd() {
       Calculator calculator = new Calculator();

        assertEquals(5, calculator.add(2,3), "2 + 3 は 5 になるはず");
        assertEquals(4, calculator.add(-1,5), "-1 + 5 は 4 になるはず");
        assertEquals(4, calculator.add(0, 4), "0 + 4 は 4 になるはず");
    }

    @Test
    void testSubtract() {
        Calculator calculator = new Calculator();
       assertEquals(2, calculator.subtract(5, 3), "5 - 3 は 2 になるはず");
       assertEquals(-3, calculator.subtract(-1, 2),  "-1 - 2 は -3 になるはず");
       assertEquals(4, calculator.subtract(4, 0), "4 - 0 は 4 になるはず");
    }
    
}
