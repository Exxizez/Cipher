import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Validator {

    /**
     * Проверка ключа
     */
    public static boolean isValidKey(int key, List<Character> alphabet) {
        return key != 0 && key % alphabet.size() != 0;
    }

    /**
     * Проверка существования файла
     */
    public static boolean isFileExists(String filePath) {
        Path path = Paths.get(filePath);
        return Files.exists(path);
    }

    /**
     * Проверка валидности алфавита (на будущее)
     */
    public static boolean isValidAlphabet(List<Character> alphabet) {
        return alphabet != null && !alphabet.isEmpty();
    }
}
