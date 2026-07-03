public class Product {
    private String name;
    private int stock;
    
    public Product(String name, int stock) {
        this.name = name;
        this.stock = stock;
    }
    
    // TODO: 在庫を1個減らすメソッド
    public void decreaseStock() {
        // TODO: stockが0より大きい場合のみ減らす
        if (stock > 0) stock--;
    }
    
    public int getStock() {
        return stock;
    }
    
    @Override
    public String toString() {
        return name + " (在庫: " + stock + "個)";
    }
}
