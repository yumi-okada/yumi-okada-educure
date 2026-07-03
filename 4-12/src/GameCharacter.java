import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameCharacter {
    private String name;
    private List<Equipment> equipmentList;

    public GameCharacter(String name) {
        this.name = name;
        this.equipmentList = new ArrayList<>();
    }

    public void addEquipment(Equipment equipment) {
        this.equipmentList.add(equipment);
    }

    public String showEquipments() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < equipmentList.size(); i++) {
            Equipment equipment = equipmentList.get(i);
            sb.append((i + 1) + ". " + equipment + "\n");
        }
        return name + "の装備:\n" + sb.toString();
    }

    public void sortEquipments() {
        Collections.sort(equipmentList);
    }

    public List<Equipment> getEquipmentList() {
    return equipmentList;
}
}
