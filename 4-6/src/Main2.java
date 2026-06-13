import java.util.ArrayList;
import java.util.Collections;

public class Main2 {
    public static void main(String[] args) {
        ArrayList<Integer> scores = new ArrayList<>();
        scores.add(85);
        scores.add(92);
        scores.add(78);
        scores.add(55);
        scores.add(43);

        double average = scores.stream()
                                .mapToInt(Integer::intValue)
                                .average().orElse(0);
        
        int maxScore = Collections.max(scores);
        
        long failedCount = scores.stream()
                                  .filter(score -> score < 60)
                                  .count();
        
        System.out.println("点数リスト: " + scores);
        System.out.println("平均点: " + average);
        System.out.println("最高点: " + maxScore);
        System.out.println("不合格者数: " + failedCount);
    }    
}
