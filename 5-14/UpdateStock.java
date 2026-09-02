import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UpdateStock {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/educure_db";
        String user = "postgres";
        String password = "CYV94XpcfV";

        // 在庫がすべて0かを確認するSQL
        String checkStockSQL = "SELECT COUNT(*) FROM products WHERE stock > 0";
        String updateSQL = "UPDATE products SET stock = CASE WHEN stock >= 10 THEN stock - 10 ELSE 0 END";

        Connection con = null;

        try { 
            con = DriverManager.getConnection(url, user, password);
            PreparedStatement checkStmt = con.prepareStatement(checkStockSQL);
            PreparedStatement updateStmt = con.prepareStatement(updateSQL);

            // 在庫がすべて0かを確認
            ResultSet rs = checkStmt.executeQuery();
            if (rs.next()) {
                int count = rs.getInt(1);
                if (count == 0) {
                    System.out.println("在庫がすべて0のため、更新は行われませんでした。");
                    rs.close();
                    checkStmt.close();
                    updateStmt.close();
                    return;
                }
            }

            // 在庫を10減らすSQLを実行
            int r = updateStmt.executeUpdate();

            // 在庫を更新
            if (r != 0) {
                System.out.println("在庫が正常に更新されました。");
            } else {
                System.out.println("在庫を更新できませんでした。");
            }
            rs.close();
            checkStmt.close();
            updateStmt.close();
        } catch (SQLException e) {
            System.out.println("在庫の更新中にエラーが発生しました。");
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
