public class Library {
    private static int availableBooks = 100;


    public static void borrowBook() {
        if (availableBooks > 0) {
            availableBooks--;
            System.out.println("1冊借りました");
        } else {
            System.out.println("貸出可能な本がありません");
        }
    }

    public static void returnBook() {
            availableBooks++;
            System.out.println("本を返却しました");
    }

    public static int getAvailableBooks() {
        return availableBooks;
    }
}
