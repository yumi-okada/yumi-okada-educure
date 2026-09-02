import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SearchProduct {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/educure_db";
        String user = "postgres";
        String password = "CYV94XpcfV";

        String query = "SELECT product_name, price FROM products WHERE price >= ?";

        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            con = DriverManager.getConnection(url, user, password);
            pstmt = con.prepareStatement(query);
            pstmt.setInt(1, 100000); // 価格が100000以上の商品を検索

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                String productName = rs.getString("product_name");
                int price = rs.getInt("price");
                System.out.println("商品名: " + productName + ", 価格: " + price);
            }
            rs.close();
            pstmt.close();
        } catch (SQLException e) {
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
