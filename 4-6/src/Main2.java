import java.util.ArrayList;

public class Main2 {
    public static void main(String[] args) {
        ArrayList<Integer> scores = new ArrayList<>();
        scores.add(85);
        scores.add(92);
        scores.add(78);
        scores.add(55);
        scores.add(43);

        System.out.println("点数リスト: " + scores);
        int total = 0;
        for (int score : scores) {
            total += score;
        }
        double average = (double)total / scores.size();
        System.out.println("平均点: " + average);

        int maxScore = scores.get(0);
        for (int score : scores) {
            if (score > maxScore) {
                maxScore = score;
            }
        }
        System.out.println("最高点: " + maxScore);
        int failedCount = 0;
        for (int score : scores) {
            if (score < 60) {
                failedCount++;
            }
        }
        System.out.println("不合格者数: " + failedCount);
    }    
}
