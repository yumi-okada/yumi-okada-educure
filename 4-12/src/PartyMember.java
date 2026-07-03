import java.util.ArrayList;
import java.util.List;

public class PartyMember implements Cloneable {
    private String name;
    private List<String> skills;

    public PartyMember(String name) {
        this.name = name;
        this.skills = new ArrayList<>();
    }

    public void addSkill(String skill) {
        this.skills.add(skill);
    }

    @Override
    public PartyMember clone() {
        try {
            PartyMember copy = (PartyMember) super.clone();
            copy.skills = new ArrayList<>(this.skills);
            return copy;
        } catch(CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    public String showSkills() {
        return "「" +  name + "」" + "のスキル: " + skills;
    }

}
