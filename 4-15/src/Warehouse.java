    // ジェネリックな倉庫クラス
public class Warehouse<T> {
    // TODO: 商品を格納するフィールドを作成
    private T item;
    
    // TODO: 商品を格納するメソッド
    public void store(T item) {
        // TODO: itemを設定し、"商品追加: [商品名]" を表示
        this.item = item;
        System.out.println("商品追加: " + item);
    }
    
    // TODO: 商品を取り出すメソッド
    public T retrieve() {
        T tempItem = item;
        item = null;
        System.out.println("取り出し: " + tempItem);
        return tempItem;
        // TODO: 
        // 1. 現在の商品を一時変数に保存
        // 2. itemをnullに設定
        // 3. "取り出し: [商品名]" を表示
        // 4. 保存しておいた商品を返す
    }
    
    // TODO: 倉庫が空かどうかをチェックするメソッド
    public boolean isEmpty() {
        return item == null;
        // TODO: itemがnullならtrue、そうでなければfalseを返す
    }
}