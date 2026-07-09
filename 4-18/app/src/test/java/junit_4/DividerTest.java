package junit_4;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class DividerTest {
    @Test
    void testNormalDivision() {
        Divider divider = new Divider();
        // 正の数の除算テスト
        assertEquals(3.0, divider.divide(6.0, 2.0), 0.0001, "6 ÷ 2 は 3 になるはず");
        assertEquals(-4.0, divider.divide(-8.0, 2.0), 0.0001 , "-8 ÷ 2 は -4 になるはず");
        assertEquals(2.5, divider.divide(5.0, 2.0), 0.0001, "5 ÷ 2 は 2.5 になるはず");

    }

    @Test
    void testExceptionDivision() {
        Divider divider = new Divider();
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> divider.divide(5.0, 0.0), "ゼロ除算で例外が発生するはず");
            assertEquals("ゼロで除算はできません", exception.getMessage());
    }
}
