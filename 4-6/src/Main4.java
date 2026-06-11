import java.util.ArrayList;
import java.util.HashSet;

public class Main4 {
    public static void main(String[] args) {
        ArrayList<String> monsterList = new ArrayList<>();
        ArrayList<String> battleLog = new ArrayList<>();
        HashSet<String> discoveredMonsters = new HashSet<>();
        ArrayList<String> undiscoveredMonsters = new ArrayList<>();

        monsterList.add("スライム");
        monsterList.add("ドラゴン");
        monsterList.add("ゴブリン");
        monsterList.add("フェニックス");
        monsterList.add("ユニコーン");

        battleLog.add("スライム");
        battleLog.add("スライム");
        battleLog.add("ドラゴン");
        battleLog.add("ゴブリン");
        battleLog.add("スライム");
        battleLog.add("ドラゴン");
        battleLog.add("スライム");
        battleLog.add("スライム");
        battleLog.add("ゴブリン");
        
        int slimeCount = 0;        

        for (String monster : battleLog) {
            discoveredMonsters.add(monster);
            if (monster.equals("スライム")) {
                slimeCount++;
            }
        }
        
        for (String monster : monsterList) {
            if (!discoveredMonsters.contains(monster)) {
                undiscoveredMonsters.add(monster);
            }
        }

        System.out.println("発見済みモンスター: " + discoveredMonsters);
        System.out.println("発見済みモンスター数: " + discoveredMonsters.size());
        System.out.println("スライムとの戦闘回数: " + slimeCount);
        System.out.println("未発見のモンスター: " + undiscoveredMonsters);
    }
}
