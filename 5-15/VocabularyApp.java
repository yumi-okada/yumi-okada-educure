import java.util.Scanner;

public class VocabularyApp {
    private WordManager wordManager;
    private Quiz quiz;
    private FileHandler fileHandler;
    private Scanner scanner;
    private DBManager dbManager;
    
    public VocabularyApp(){
        this.dbManager = new DBManager();
        this.wordManager = new WordManager(dbManager);
        this.quiz = new Quiz(wordManager);
        this.fileHandler = new FileHandler();
        this.scanner = new Scanner(System.in , "MS932");
    }

    public void start() {
        int choice = 0;

        while (choice != 7) {
            System.out.println("=== 英単語暗記アプリ ===");
            System.out.println("1: 単語を登録する");
            System.out.println("2: クイズを受ける");
            System.out.println("3: CSVファイルから単語をインポート");
            System.out.println("4: CSVファイルに単語をエクスポート");
            System.out.println("5: 単語を削除する");
            System.out.println("6: 単語を更新する");
            System.out.println("7: 終了する");
            
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine();
            } else {
                System.out.println("1～7の数字を入力してください。");
                scanner.nextLine();
                continue;
            }            

            switch (choice) {
                case 1:
                    registerWord();
                    break;
                case 2:
                    startQuiz();
                    break;
                case 3:
                    importWords();
                    break;
                case 4:
                    exportWords();
                    break;
                case 5:
                    deleteWord();
                    break;
                case 6:
                    updateWord();
                    break;
                case 7:
                    cleanup();
                    System.out.println("アプリケーションを終了します。");
                    break;
                default:
                    System.out.println("無効な選択です。");
            }
        }
    }

    private void registerWord() {
        System.out.println("英単語を入力してください：");
        String english = scanner.nextLine();
        
        System.out.println("日本語訳を入力してください：");
        String japanese = scanner.nextLine();
        
        if (english.isBlank() || japanese.isBlank()) {
            System.out.println("英単語と日本語訳を入力してください。");
            return;
        }

        if (english.length() > 100 || japanese.length() > 100) {
            System.out.println("英単語と日本語訳は100文字以内で入力してください。");
            return;
        }

        Word word = new Word(english, japanese);
        wordManager.addWord(word);
        System.out.println("単語を登録しました。");
    }

    private void startQuiz() {
        quiz = new Quiz(wordManager);
        int wordCount = wordManager.getWordCount();

        if (wordCount < 1) {
            System.out.println("登録された単語がありません。");
        } else {
            System.out.println("=== クイズを開始します ===");
            for (int i = 0; i < wordCount; i++) {
                Word word = quiz.getRandomWord();
                System.out.println(word.getEnglish() +"の意味は？");
                String answer = scanner.nextLine();
                if (quiz.checkAnswer(word, answer)) {
                    System.out.println("正解です！");            
                } else {
                    System.out.println("不正解です。正解は" + word.getJapanese() + "でした。");
                }
            }
            System.out.println("クイズ終了！\n" + quiz.getTotalQuestions() + "問中" + quiz.getScore() + "問正解でした！");
        }
    }
    private void importWords() {
        System.out.println("CSVファイル名を入力してください: ");
        String filename = scanner.nextLine();
        fileHandler.importFromCSV(filename, wordManager);
    }
    private void exportWords(){
        System.out.println("CSVファイル名を入力してください: ");
        String filename = scanner.nextLine();
        fileHandler.exportToCSV(wordManager.getWords(), filename);
    }

    private void deleteWord() {
        System.out.println("削除する英単語を入力してください: ");
        String english = scanner.nextLine();

        int result = wordManager.deleteWord(english);

        if (result > 0) {
            System.out.println("単語を削除しました。");
        } else if (result == 0) {
            System.out.println("該当する単語がありません。");
        } else {
            System.out.println("単語の削除に失敗しました。");
        }
    }

    private void updateWord() {
        System.out.println("更新する英単語を入力してください：");
        String english = scanner.nextLine();

        System.out.println("新しい日本語訳を入力してください：");
        String newJapanese = scanner.nextLine();

        if (english.isBlank()
                || newJapanese.isBlank()
                || english.length() > 100
                || newJapanese.length() > 100) {

            System.out.println("入力内容が正しくありません。");
            return;
        }

        int result = wordManager.updateWord(english, newJapanese);
            if (result > 0) {
            System.out.println("単語を更新しました。");
        } else if (result == 0) {
            System.out.println("該当する単語がありません。");
        } else {
            System.out.println("単語の更新に失敗しました。");
        }
    }

    private void cleanup() {
        dbManager.close();
        scanner.close();
    }

    public static void main(String[] args) {
        VocabularyApp app = new VocabularyApp();
        app.start();
    }
}
