public class SavingAccount implements BankAccount {
 
    private String accountHolder;
    private int balance;

    public SavingAccount(String accountHolder, int initialBalance) {
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
    }

    @Override
    public void deposit(int amount) {
        if(amount <= 0) {
            System.out.println("入金額は1円以上を入力してください");
            return;
        }
        balance += amount;
        System.out.println(amount + "円入金しました");
    }

    @Override
    public void withdraw(int amount) {
        if(amount <= 0) {
            System.out.println("出金額は1円以上を入力してください");
            return;
        }
        if (amount > balance) {
            System.out.println("残高不足です");
        } else {
            balance -= amount;
            System.out.println(amount + "円出金しました");
        }
    }

    @Override
    public int getBalance() {
        return balance;
    }

    @Override
    public void displayAccountInfo() {
        System.out.println("口座名義人: " + accountHolder);
        System.out.println("残高: " + balance);
    }
}
