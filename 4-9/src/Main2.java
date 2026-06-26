public class Main2 {
    public static void main(String[] args) {
        int[] numbers = {10, 20, 30};
        ArrayAccessor accessor = new ArrayAccessor(numbers);
        
        System.out.println("\n位置5の要素");
        // TODO: try-catchで位置5の要素を取得
        try {
            accessor.getElement(5);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("エラー: " + e.getMessage());
        }
    }
}
