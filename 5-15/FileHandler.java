import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FileHandler {
    public void exportToCSV(List<Word> words, String filename) {
        try (FileWriter writer = new FileWriter(filename)) {
            for (Word word : words) {
                writer.write(word.getEnglish() + "," + word.getJapanese() + "\n");
            }
            System.out.println(words.size() + "個の単語を保存しました。");
        } catch (IOException e) {
            e.printStackTrace();
        }  
    }

    public void importFromCSV(String filename, WordManager wordManager){
        int importedCount = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] values = line.split(",", -1);
                if (values.length != 2
                        || values[0].isBlank()
                        || values[1].isBlank()
                        || values[0].length() > 100
                        || values[1].length() > 100) {
                    System.out.println("CSVファイルの形式が正しくありません。");
                    return;
                }

                Word word = new Word(values[0], values[1]);
                wordManager.addWord(word);
                importedCount++;
            }

            System.out.println(importedCount + "個の単語を読み込みました。");

        } catch (IOException e) {
            System.out.println("ファイルが見つからないか、読み込みに失敗しました。");
        }
    }
}
