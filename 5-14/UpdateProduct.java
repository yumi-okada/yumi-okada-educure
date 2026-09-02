import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateProduct {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/educure_db";
        String user = "postgres";
        String password = "CYV94XpcfV";
        
        String updatePriceSQL = "UPDATE products SET price = price - 5000 WHERE product_name = 'タブレット'";
        String updateStockSQL = "UPDATE products SET stock = stock + 5 WHERE price < 50000";

        Connection con = null;

        try { 
            con = DriverManager.getConnection(url, user, password);
            PreparedStatement updatePriceStmt = con.prepareStatement(updatePriceSQL);
            PreparedStatement updateStockStmt = con.prepareStatement(updateStockSQL);
            
            // タブレットの価格を5000値下げるSQLを実行
            int p = updatePriceStmt.executeUpdate();
            System.out.println("価格を値下げした行数: " + p);
            // 価格が50000未満の商品在庫を5増やすSQLを実行
            int s = updateStockStmt.executeUpdate();
            System.out.println("在庫を増やした行数: " + s);

            updatePriceStmt.close();
            updateStockStmt.close();
        } catch (SQLException e) {
            System.out.println("商品の更新中にエラーが発生しました。");
            e.printStackTrace();
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
