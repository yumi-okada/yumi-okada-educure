public class ArrayAccessor {
    private int[] array;
    public ArrayAccessor(int[] array) {
        this.array = array;
    }

    public int getElement(int index) {
        if (index < 0 || index >= array.length) {
            throw new IndexOutOfBoundsException("指定された位置は範囲外です");
        }
        return array[index];
    }
}
