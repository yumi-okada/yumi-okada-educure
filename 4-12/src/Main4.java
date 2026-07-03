public class Main4 {
    public static void main(String[] args) {
        PartyMember member = new PartyMember("アリス");
        member.addSkill("ファイア");
        member.addSkill("ブリザード");

        PartyMember copy = member.clone();
        copy.addSkill("サンダー");
        System.out.println("--- 深いコピー後にスキル追加 ---");
        System.out.println("元のキャラクター" + member.showSkills());
        System.out.println("コピーしたキャラクター" + copy.showSkills());

    }
}
