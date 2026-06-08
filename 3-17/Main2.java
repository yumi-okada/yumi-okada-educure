
public class Main2 {
    public static void main(String[] args) {
        Student student = new Student("田中太郎", 85);
        System.out.println(student.getName() + "さんの点数: " + student.getScore() + "点");

        student.setScore(200);
        student.setName("");
    }
}
