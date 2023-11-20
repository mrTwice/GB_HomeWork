import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Date;

public class Backup {
    private static Date now = new Date();
    private static final String BACKUP_PATH = "./Backup" + " " + now.toString();

    public static void main(String[] args) {

        try {
            copyFiles(".", createDirectory(BACKUP_PATH));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Метод копирования файлов.
     * @param from источник
     * @param to назначение
     * @throws IOException
     */
    private static void copyFiles(String from, String to) throws IOException {
        File currentDirectory = new File(from);
        File[] files = currentDirectory.listFiles();
        for (File file: files) {
            if(file.getName().toLowerCase().contains("backup")) continue;
            if(file.isFile()) {
                Files.copy(file.toPath(), new File(to + File.separator + file.getName()).toPath());
            } else {
                copyFiles(file.getPath(), createDirectory(BACKUP_PATH + File.separator + file.getPath()));
            }
        }

    }

    /**
     * Метод создания директории.
     * @param path путь
     * @return возращаемая строка, содержащая путь
     */
    private static String createDirectory(String path){
        File directory = new File(path);
        directory.mkdir();
        return directory.getPath();
    }
}
