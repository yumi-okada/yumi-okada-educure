public class Main2 {
    public static void main(String[] args) {
        Book book1 = new Book("Java入門", 2500, "山田太郎");
        book1.stockQuantity = 1;

        book1.displayInfo();
        book1.checkStock();
    }
}
