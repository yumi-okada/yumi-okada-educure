import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main4 {
    public static void main(String[] args) {
        Path source = Paths.get("source.txt");
        Path backupFile = Paths.get("backup/source.txt");
        File backupFolder = new File("backup/");
        File archiveFolder = new File("archive/");
        Path archiveFile = Paths.get("archive/source.txt");

        try {
            if (!backupFolder.exists()) {
                backupFolder.mkdir();
            }
            if (!archiveFolder.exists()) {
                archiveFolder.mkdir();
            }    
            // ファイルをコピー
            Files.copy(source, backupFile);
            System.out.println("ファイルが 'backup/' にコピーされました。");
            if (Files.exists(backupFile)) {
                System.out.println("コピーの確認：成功");
            }

            // ファイルを移動
            Files.move(backupFile, archiveFile);
            System.out.println("ファイルが 'archive/' に移動されました。");
            if (Files.exists(archiveFile) && !Files.exists(backupFile)) {
                System.out.println("移動の確認：成功");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
