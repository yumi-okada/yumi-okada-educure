import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FileHandler {
    public void exportToCSV(List<Word> words, String filename) {
        try (FileWriter writer = new FileWriter(filename)) {
            writer.write("English,Japanese\n");
            for (Word word : words) {
                writer.write(word.getEnglish() + "," + word.getJapanese() + "\n");
            }
            System.out.println(words.size() + "個の単語を保存しました。");
        } catch (IOException e) {
            e.printStackTrace();
        }  
    }

    public void importFromCSV(String filename, WordManager wordManager){
        // CSVファイルを読み込む
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            br.readLine(); // ヘッダー行をスキップ
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");

                Word word = new Word(values[0], values[1]);
                wordManager.addWord(word);
            }
            System.out.println(wordManager.getWordCount() + "個の単語を読み込みました。");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
