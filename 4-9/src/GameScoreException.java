public abstract class GameScoreException extends Exception {
    private String message;
    private int score;

    public GameScoreException(String message, int score) {
        this.message = message;
        this.score = score;
    }

    public String getMessage() {
        return message;
    }

    public int getScore() {
        return score;
    }
}
