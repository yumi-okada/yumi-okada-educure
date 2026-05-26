public class Wizard extends GameCharacter {
    public int mp;

    public Wizard(String name, int hp, int mp) {
        super(name, hp);
        this.mp = mp;
    }

    public void showStatus() {
        System.out.println("名前: " + name);
        System.out.println("HP: " + hp);
        System.out.println("MP: " + mp);
    }
}
