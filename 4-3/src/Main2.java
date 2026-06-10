public class Main2 {
    public static String shortenMessage(String message, int maxLength) {
        if (message.length() > maxLength) {
            StringBuilder sb = new StringBuilder();
            sb.append(message.substring(0, maxLength));
            sb.append("...");
            return sb.toString();
        } else {
            return message;
        }
    }

    public static void main(String[] args) {
        StringBuilder message = new StringBuilder();
        message.append("これは非常に長いチャットメッセージです。省略する必要があります。");
        System.out.println("原文: " + message);
        System.out.println("省略後(10文字): " + shortenMessage(message.toString(), 10));
        System.out.println("省略後(20文字): " + shortenMessage(message.toString(), 20));
    }
}
