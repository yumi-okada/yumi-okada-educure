public class Main4 {
    public static void main(String[] args) {
        String[] students = {
            "アリス", 
            "ボブ",
            "チャーリー",
            null,
            "イヴ"
        };

        StudentManager manager = new StudentManager();

        for(String student : students){
            manager.addStudent(student);
        }

        try{
            manager.addStudent("ジョン");
        } catch(IllegalStateException e){
            System.out.println(e.getMessage());
        }

        try{
            System.out.println("学生ID 2: " + manager.getStudent(2));
        } catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }

        try {
            System.out.println("学生ID 3: " + manager.getStudent(3));
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
            System.out.println("学生ID 3: null");
        }

        try {
            System.out.println("学生ID 10: " + manager.getStudent(10));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            System.out.println("学生ID 10: null");
        }

        try {
            manager.updateStudent(0, "フランク");
            manager.updateStudent(1,"ボビー");
            System.out.println("更新後の学生ID 1: " + manager.getStudent(1));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            manager.updateStudent(10,null);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        
    }
}
