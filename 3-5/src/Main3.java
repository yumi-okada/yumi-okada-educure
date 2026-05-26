public class Main3 {
    public static void main(String[] args) {
        BankAccount account1;
        account1 = new BankAccount(5000);

        // 同じインスタンスを参照する
        BankAccount account2 = account1;
        account2.balance = 3000;
        System.out.println("口座1の残高: " + account1.balance);
        System.out.println("口座2の残高: " + account2.balance);
    }
}
