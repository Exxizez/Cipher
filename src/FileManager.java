import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;

public class FileManager {

    /**
     * Логика чтения файла
     */
    public static String readFile(String filePath) {
        try {
            return Files.readString(Paths.get(filePath)).toLowerCase();
        } catch (IOException e) {
            throw new RuntimeException("Не удалось прочитать файл!");
        }
    }

    /**
     * Логика чтения файла в List
     */
    public static Set<String> readFileInSet(String filePath) {
        Set<String> dictionary = new HashSet<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                dictionary.add(line.trim().toLowerCase());
            }
        } catch (IOException e) {
            throw new RuntimeException("Не удалось прочитать файл");
        }
        return dictionary;
    }

    /**
     * Логика записи файла
     */
    public static void writeFile(String content, String filePath) {
        try {
            Files.write(Paths.get(filePath), content.getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Не удалось записать в файл!");
        }
    }
}
