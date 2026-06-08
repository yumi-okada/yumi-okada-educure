
public class Library {
    public void lendBook(Book book) {
        if (!book.isLent()) {
            book.setLent(true);
            System.out.println("「" + book.getTitle() + "」を貸し出しました");
        } else {
            System.out.println("エラー: この本は既に貸し出し中です");
        }
    }

    public void returnBook(Book book) {
        if (book.isLent()) {
            book.setLent(false);
            System.out.println("「" + book.getTitle() + "」が返却されました");
        } else {
            System.out.println("エラー: この本は貸し出されていません");
        }
    }
}
