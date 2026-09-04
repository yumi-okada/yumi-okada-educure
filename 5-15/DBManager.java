import java.sql.*;

public class DBManager {
    private Connection connection;
    private String url = "jdbc:postgresql://localhost:5432/vocabulary_db";
    private String user = "postgres";
    private String password = "CYV94XpcfV";

    public DBManager() {
        try {
            connection = DriverManager.getConnection(url, user, password);
            initializeDatabase();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void initializeDatabase() {
        String createTableSQL = "CREATE TABLE IF NOT EXISTS words ("
                + "id SERIAL PRIMARY KEY,"
                + "english VARCHAR(100) NOT NULL,"
                + "japanese VARCHAR(100) NOT NULL,"
                + "created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP"
                + ")";

        String createIndexSQL =
            "CREATE INDEX IF NOT EXISTS idx_english "
            + "ON words (english)";
        try (Statement stmt = connection.createStatement()) {
            stmt.execute(createTableSQL);
            stmt.execute(createIndexSQL);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public Connection getConnection() {
        return connection;
    }

    public void close() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
