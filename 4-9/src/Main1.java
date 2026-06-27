public class Main1 {
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        
        // 割り算の実行
        try {
            // TODO: 10 ÷ 0 を計算
            int result = calc.divide(10, 0);
            // 10 ÷ 0 の結果を表示
            System.out.println("10 ÷ 0 = " + result);
        } catch (IllegalArgumentException e) {
            // TODO: エラーメッセージを表示
            System.out.println("10 ÷ 0 = エラー：" + e.getMessage());
        }
    }
}
