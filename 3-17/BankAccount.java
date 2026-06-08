

public class BankAccount {
    private int balance;

    public BankAccount(int initialBalance) {
        this.balance = initialBalance;
    }

    public int getBalance() {
        return balance;
    }

    public void deposit(int amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println(amount + "円入金しました");
        } else {
            System.out.println("無効な金額です。入金額は正の数でなければなりません。");
        }
    }

    public void withdraw(int amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println(amount + "円引き出しました");
        }else if (amount <= 0) {
            System.out.println("無効な金額です。引き出し額は正の数でなければなりません。");
        }else{
            System.out.println("引き出しに失敗しました。残高が不足しています。");
        }
    }
}
