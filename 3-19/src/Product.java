public class Product {
    String name;
    int price;

    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String toString() {
        return "商品名: " +name + " (" + price + "円)";
    }
}
