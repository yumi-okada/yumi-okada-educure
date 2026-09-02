import java.sql.*;

public class ProductMaintenance {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/educure_db";
        String user = "postgres";
        String password = "CYV94XpcfV";

        String updatePriceSQL = "UPDATE products SET price = 0 WHERE stock = 0";
        String deleteProductSQL = "DELETE FROM products WHERE price >= 200000";
        String updateStockSQL = "UPDATE products SET stock = 20 WHERE price >= 100000 AND stock <= 10";


        Connection con = null;

        try { 
            con = DriverManager.getConnection(url, user, password);
            // 自動コミットを無効にする
            con.setAutoCommit(false);
            PreparedStatement updatePriceStmt = con.prepareStatement(updatePriceSQL);
            PreparedStatement deleteProductStmt = con.prepareStatement(deleteProductSQL);
            PreparedStatement updateStockStmt = con.prepareStatement(updateStockSQL);
            
            // 在庫数0の商品の価格を0に設定するSQLを実行
            int p = updatePriceStmt.executeUpdate();
            
            // 価格が200000以上の商品を削除するSQLを実行
            int d = deleteProductStmt.executeUpdate();
            
            // 価格が100000以上、在庫数10以下の商品在庫を20に更新するSQLを実行
            int s = updateStockStmt.executeUpdate();
            
            // すべての操作をコミット
            con.commit();

            System.out.println("影響を受けた行数(在庫数0の商品価格を0に設定): " + p);
            System.out.println("影響を受けた行数(価格が200000以上の商品削除): " + d);
            System.out.println("影響を受けた行数(価格が100000以上、在庫数10以下の商品を在庫数20に更新): " + s);

            updatePriceStmt.close();
            deleteProductStmt.close();
            updateStockStmt.close();
        } catch (SQLException e) {
            System.out.println("商品の更新中にエラーが発生しました。");
            // エラーが発生した場合はロールバック
            if(con != null) {
                try {
                    con.rollback();
                } catch (SQLException rollbackException) {
                    rollbackException.printStackTrace();
                }
            }

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