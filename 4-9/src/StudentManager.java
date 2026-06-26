public class StudentManager {
    private String[] students = new String[5];
    private int count = 0;
        
    public void addStudent(String name) {
        // 追加
        if(count >= students.length){
            throw new IllegalStateException("エラー: これ以上学生を追加できません。リストがいっぱいです。");
        }
        students[count] = name;
        count++;
    }
    
    public String getStudent(int id) {
        validateId(id);
        validateStudentExists(id);
        return students[id];
    }
    
    public void updateStudent(int id, String name) {
        validateId(id);
        students[id] = name;
    }

    //追加
    private void validateId(int id){
        // 追加
        if(id < 0 || id >= students.length) {
            throw new IllegalArgumentException("エラー: 無効な学生IDです: " + id);
        }
    }

    private void validateStudentExists(int id){
        // 追加
        if (students[id] == null){
            throw new IllegalStateException("エラー: 学生ID " + id + "にデータがありません。");
        }
    }
}
