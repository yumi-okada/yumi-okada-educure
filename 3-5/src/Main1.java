public class Main1 {
    public static void main(String[] args) {
        Weapon sword = new Weapon("魔法の剣", 50);
        GameCharacter character = new GameCharacter("剣士アレックス", 100, sword);

        System.out.println(
                character.name + "は" +
                        character.weapon.name +
                        "を装備しています");
    }
}
