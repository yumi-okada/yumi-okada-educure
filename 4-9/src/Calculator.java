public class Calculator {
    public int divide(int a, int b) throws IllegalArgumentException {
        if (b == 0) {
            throw new IllegalArgumentException("0で割ることはできません");
        }
        return a / b;
    }
}
