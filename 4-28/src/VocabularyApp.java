import java.util.Scanner;

public class VocabularyApp {
    private WordManager wordManager;
    private Quiz quiz;
    private FileHandler fileHandler;
    private Scanner scanner;
    
    public VocabularyApp(){
        this.wordManager = new WordManager();
        this.quiz = new Quiz(wordManager);
        this.fileHandler = new FileHandler();
        this.scanner = new Scanner(System.in , "MS932");
    }

    public void start() {
        int choice = 0;

        while (choice != 5) {
            System.out.println("メニューを選択してください");
            System.out.println("1: 単語を登録する");
            System.out.println("2: クイズを受ける");
            System.out.println("3: CSVファイルから単語をインポート");
            System.out.println("4: CSVファイルに単語をエクスポート");
            System.out.println("5: 終了する");
            
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
            } else {
                System.out.println("1～5の数字を入力してください。");
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
                    break;
                default:
                    System.out.println("無効な選択です。");
            }
        }
        System.out.println("アプリケーションを終了します。");
    }

    private void registerWord() {
        scanner.nextLine(); // nextInt() の改行を消費
        
        System.out.println("英単語を入力してください：");
        String english = scanner.nextLine();
        
        System.out.println("日本語訳を入力してください：");
        String japanese = scanner.nextLine();
        
        if (english.isEmpty() || japanese.isEmpty()) {
            System.out.println("英単語と日本語訳を入力してください。");
            return;
        }

        Word word = new Word(english, japanese);
        wordManager.addWord(word);
        System.out.println("単語を登録しました。");
    }

    private void startQuiz() {
        scanner.nextLine();
        // 2回目以降のリセットをかけるために再生成
        quiz = new Quiz(wordManager);

        if (wordManager.getWordCount() < 1) {
            System.out.println("登録された単語がありません。");
        }else {
            for (int i = 0; i < wordManager.getWordCount(); i++) {
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
        String filename = scanner.next();
        fileHandler.importFromCSV(filename, wordManager);
    }
    private void exportWords(){
        System.out.println("CSVファイル名を入力してください: ");
        String filename = scanner.next();
        fileHandler.exportToCSV(wordManager.getWords(), filename);
    }

    public static void main(String[] args) {
        VocabularyApp app = new VocabularyApp();
        app.start();
    }
}
