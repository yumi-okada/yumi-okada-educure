public class Main3 {
    public static boolean validateUsername(String username){
        if(username.length() < 4 || username.length() > 16) {
            return false;
        }
        if(!username.matches("^[a-zA-Z0-9_]+$") || !username.matches(".*[a-zA-Z].*")){
            return false;
        }
        return true;
    }

    public static boolean validatePassword(String password) {
        if(password.length() < 8){
            return false;
        }
        if(!password.matches(".*[A-Z].*")){
            return false;
        }
        if(!password.matches(".*[a-z].*")){
            return false;
        }
        if(!password.matches(".*[0-9].*")){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String[] usernames = {"Player_1", "123456", "P@layer"};
        String[] passwords = {"Password123", "password123", "Pass"};

        System.out.println("ユーザー名チェック:");
        for (String username : usernames) {
            if(validateUsername(username)){
                System.out.println(username + ": 有効");
            } else {
                System.out.println(username + ": 無効");
            }
        }

        System.out.println("パスワードチェック:");
        for (String password : passwords) {
            if(validatePassword(password)){
                System.out.println(password + ": 有効");
            } else {
                System.out.println(password + ": 無効");
            }
        }
    }
}
