import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertProduct {

    public static void main(String[] args) {
        String url =
                "jdbc:postgresql://localhost:5432/educure_db";
        String user = "postgres";
        String password = "CYV94XpcfV";

        String insertSQL =
                "INSERT INTO products "
                + "(product_name, price, stock) "
                + "VALUES (?, ?, ?)";

        Connection con = null;

        try {
            con = DriverManager.getConnection(
                    url,
                    user,
                    password
            );

            // 商品を追加するSQL文を準備
            PreparedStatement pstmt =
                    con.prepareStatement(insertSQL);

            // 「?」に値を順番に流し込む
            pstmt.setString(1, "スマートフォン");
            pstmt.setInt(2, 80000);
            pstmt.setInt(3, 30);

            // SQLを実行して、追加された行数を受け取る
            int r = pstmt.executeUpdate();

            if (r != 0) {
                System.out.println(
                        r + "件の商品を追加しました"
                );
            } else {
                System.out.println(
                        "商品の追加に失敗しました"
                );
            }

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