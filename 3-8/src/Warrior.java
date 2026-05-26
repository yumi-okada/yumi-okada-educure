public class Warrior extends Character {
    public String job = "戦士";

    public Warrior(String name, int hp) {
        super(name, hp);
    }

    @Override
    public void showStatus() {
        super.showStatus();
        System.out.println("職業: " + job);
    }
}
