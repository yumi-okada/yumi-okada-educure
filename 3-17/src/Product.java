public class Product {
    private String name;
    private int stock;

    public Product(String name, int stock) {
        this.name = name;
        this.stock = stock;
    }

    public String getName() {
        return name;
    }

    public int getStock() {
        return stock;
    }

    public void addStock(int amount) {
        if (amount > 0) {
            stock += amount;
            System.out.println(amount + "個追加しました");
        } else {
            System.out.println("エラー: 無効な数量です。追加する数量は正の数でなければなりません。");
        }
    }

    public void removeStock(int amount) {
        if (amount > 0 && amount <= stock) {
            stock -= amount;
            System.out.println(amount + "個販売しました");
        } else if (amount <= 0) {
            System.out.println("エラー: 無効な数量です。減らす数量は正の数でなければなりません。");
        } else {
            System.out.println("エラー: 在庫が不足しています");
        }
    }
    
}
