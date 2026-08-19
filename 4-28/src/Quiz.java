public class Quiz {
    private WordManager wordManager;
    
    private int score;
    private int totalQuestions;
    
    public Quiz(WordManager wordManager){
        this.wordManager = wordManager;
        this.score = 0;
        this.totalQuestions = 0;
    }
    
    public boolean checkAnswer(Word word, String answer){
        totalQuestions++;

        if (word.getJapanese().equals(answer)) {
            score++;
            return true;
        }
        return false;
    }

    public Word getRandomWord() {
        return wordManager.getWords().get((int)(Math.random() * wordManager.getWordCount()));
    }

    public int getScore(){
        return score;
    }
    
    public int getTotalQuestions(){
        return totalQuestions;
    }
}
