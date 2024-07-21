import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileManager {

    public String readFile(String filePath) {
        try {
            return Files.readString(Paths.get(filePath));
        } catch (IOException e) {
            throw new RuntimeException("Не удалось прочитать файл!");
        }
    }
    public void writeFile(String content, String filePath) {
        // Логика записи файла
        try {
            Files.write(Paths.get(filePath), content.getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Не удалось записать в файл!");
        }
    }
}
