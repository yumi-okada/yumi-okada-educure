public class Main5 {
    public static void main(String[] args) {
        GameCharacter character = new GameCharacter("勇者A");
        Equipment equipment1 = new Equipment("伝説の剣", 100, 0);
        Equipment equipment2 = new Equipment("光の盾", 0, 80);
        Equipment equipment3 = new Equipment("魔法の靴", 10, 20);

        character.addEquipment(equipment1);
        character.addEquipment(equipment2);
        character.addEquipment(equipment3);

        System.out.println("--- キャラクター装備情報 ---");
        System.out.println(character.showEquipments());

        Equipment copyEquipment = equipment1.clone();
        if(copyEquipment.equals(equipment1)){
            System.out.println("装備の複製テスト: OK");
        } else{
            System.out.println("装備の複製テスト: NG");
        }

        if (equipment1.compareTo(equipment2) < 0) {
            System.out.println("装備の比較テスト: OK");   
        } else {
            System.out.println("装備の比較テスト: NG");
        }

        character.sortEquipments();
        if (character.getEquipmentList().get(0).getPower() > character.getEquipmentList().get(1).getPower() && 
            character.getEquipmentList().get(1).getPower() > character.getEquipmentList().get(2).getPower()) {
            System.out.println("装備の強さソート: OK");
        }else {
            System.out.println("装備の強さソート: NG");
        }


    }
}
