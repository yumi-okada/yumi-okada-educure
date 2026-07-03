public class Main2 {
    public static void main(String[] args) {
        // 果物倉庫のテスト
        System.out.println("果物倉庫: ");
        // TODO: String型の倉庫を作成
        Warehouse<String> fruitWarehouse = new Warehouse<>();
        
        // TODO: バナナを格納
        fruitWarehouse.store("バナナ");
        // TODO: バナナを取り出し
        fruitWarehouse.retrieve();
        // TODO: 空チェック
        System.out.println("空チェック: " + fruitWarehouse.isEmpty());

        // 日用品倉庫のテスト
        System.out.println("\n日用品倉庫:");
        // TODO: 同様の操作を日用品倉庫でも実行
        Warehouse<String> dailyWarehouse = new Warehouse<>();
        dailyWarehouse.store("ティッシュ");
        dailyWarehouse.retrieve();
        System.out.println("空チェック: " + dailyWarehouse.isEmpty());
    }
}
