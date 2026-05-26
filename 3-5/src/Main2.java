public class Main2 {
    public static void main(String[] args) {
        Player player = new Player("勇者", 30);

        HealingPotion potion = new HealingPotion();
        potion.displayInfo(player);
        potion.heal(player);
        System.out.println("プレイヤーのHP: " + player.hp);
    }
}
