public class Inventory<T> {
    // TODO: 商品を格納するフィールドを作成
    private T item;
    private final ProductCategory category;
    
    public Inventory(ProductCategory category) {
        this.category = category;
    }
    
    // TODO: 商品を入荷するメソッド
    public void stockIn(T item) {
        // TODO: 
        // 1. itemを設定
        // 2. "[カテゴリ名]コーナー: [商品名]を入荷" を表示
        this.item = item;
        System.out.println(category.getDisplayName() + "コーナー: " + item + "を入荷");
    }
    
    // TODO: 商品を出荷するメソッド
    public T stockOut() {
        // TODO:
        // 1. 現在の商品を一時変数に保存
        // 2. itemをnullに設定
        // 3. 保存しておいた商品を返す
        T tempItem = item;
        item = null;
        return tempItem;

    }
    
    // TODO: 現在の在庫を取得するメソッド
    public T getCurrentStock() {
        // TODO: 現在の商品を返す
        return item;
    }
}
