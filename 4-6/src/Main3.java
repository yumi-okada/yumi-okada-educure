import java.util.HashMap;
import java.util.Map;

public class Main3 {
    public static void main(String[] args) {
        Map<String, Integer> stock = new HashMap<>();
        stock.put("おにぎり", 15);
        stock.put("サンドイッチ", 8);
        stock.put("お弁当", 5);

        System.out.println("在庫状況: " + stock);
        stock.put("おにぎり", stock.get("おにぎり") - 1);
        System.out.println("おにぎりを1個販売しました");
        System.out.println("在庫状況: " + stock);
        boolean hasIcecream = stock.containsKey("アイスクリーム");
        System.out.println("アイスクリームは在庫がありますか？: " + hasIcecream);
    }
}
