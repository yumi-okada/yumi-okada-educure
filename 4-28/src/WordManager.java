import java.util.ArrayList;
import java.util.List;

public class WordManager {
    private List<Word> words;

    public WordManager() {
        words = new ArrayList<>();
        // 初期化
    }

    public void addWord(Word word) {
        words.add(word);
        // 単語を追加
        
    }

    public List<Word> getWords() {
        return words;
        // 単語一覧を返す
    }

    public int getWordCount() {
        return words.size();
        // 単語数を返す
    }
}
