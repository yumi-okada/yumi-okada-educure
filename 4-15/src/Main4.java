public class Main4 {
    public static void main(String[] args) {
        InventoryManager manager = new InventoryManager();
        
        // TODO: バナナを追加
        manager.addProduct("バナナ", 5);
        
        // TODO: バナナを販売
        manager.sellProduct("バナナ");
        
        // TODO: 存在しない商品を検索
        System.out.print("存在しない商品の検索: ");
        manager.sellProduct("いちご");
    }
}
