public enum ProductCategory {
    // TODO: FRUITS, VEGETABLES, DAIRYを定義
    FRUITS("果物"),
    VEGETABLES("野菜"),
    DAIRY("乳製品");

    // それぞれ表示名（"果物", "野菜", "乳製品"）を持たせる

    private final String displayName;    
    ProductCategory(String displayName) {
        this.displayName = displayName;
    }
    
    public String getDisplayName() {
        return displayName;
    }
}