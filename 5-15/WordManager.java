import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class WordManager {
    private DBManager dbManager;

    public WordManager(DBManager dbManager) {
        this.dbManager = dbManager;
    }

    public void addWord(Word word) {
        String sql = "INSERT INTO words (english, japanese) VALUES (?, ?)";

        try (PreparedStatement pstmt = dbManager.getConnection().prepareStatement(sql)) {
            pstmt.setString(1, word.getEnglish());
            pstmt.setString(2, word.getJapanese());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    
    public List<Word> getWords() {
        List<Word> words = new ArrayList<>();
        String sql = "SELECT english, japanese FROM words";

        try (PreparedStatement stmt = dbManager.getConnection().prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                String english = rs.getString("english");
                String japanese = rs.getString("japanese");
                words.add(new Word(english, japanese));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return words;
    }

    public int getWordCount() {
        int count = 0;
        String sql = "SELECT COUNT(*) FROM words";

        try (PreparedStatement stmt = dbManager.getConnection().prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            if (rs.next()) {
                count = rs.getInt(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    public int deleteWord(String english) {
        String sql = "DELETE FROM words WHERE english = ?";

        try (PreparedStatement stmt =
                     dbManager.getConnection().prepareStatement(sql)) {

            stmt.setString(1, english);
            return stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public int updateWord(String english, String newJapanese) {
        String sql = "UPDATE words SET japanese = ? WHERE english = ?";

        try (PreparedStatement stmt = dbManager.getConnection().prepareStatement(sql)) {

            stmt.setString(1, newJapanese);
            stmt.setString(2, english);
            return stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }
}
