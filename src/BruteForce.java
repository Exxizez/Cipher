import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BruteForce {

    /**
     * Логика brute force
     */
    public static String decryptByBruteForce(String encryptedText, List<Character> alphabet, Set<String> dictionary) {
        StringBuilder bestDecryption = new StringBuilder();
        int key = -1;
        int maxWordMatches = 0;
        int alphabetLength = alphabet.size();

        for (int shift = 0; shift < alphabetLength; shift++) {
            StringBuilder decryptedAttempt = new StringBuilder();
            for (char encryptedChar : encryptedText.toCharArray()) {
                int index = alphabet.indexOf(encryptedChar);
                if (index != -1) {
                    int decryptedIndex = (index - shift + alphabetLength) % alphabetLength;
                    decryptedAttempt.append(alphabet.get(decryptedIndex));
                } else {
                    decryptedAttempt.append(encryptedChar);
                }
            }
            int wordMatches = countWordMatches(decryptedAttempt.toString(), dictionary);
            if (wordMatches > maxWordMatches) {
                key = shift;
                maxWordMatches = wordMatches;
                bestDecryption.setLength(0);  // Очистить текущий лучший результат
                bestDecryption.append("key = ").append(key);
                bestDecryption.append("\n");
                bestDecryption.append(decryptedAttempt);

            }
        }
        return bestDecryption.toString();
    }

    /**
     * Логика подсчетка количества совпадений в словаре
     */
    private static int  countWordMatches(String text, Set<String> dictionary) {
        String[] words = text.split("\\P{L}+");  // Разделить текст на слова, используя регулярные выражения
        int matches = 0;
        for (String word : words) {
            if (dictionary.contains(word.toLowerCase())) {
                matches++;
            }
        }
        return matches;
    }

    /**
     * подгрузка словаря
     */
    public static Set<String> loadDictionary(String filePath) {
        Set<String> lines = FileManager.readFileInSet(filePath);
        Set<String> dictionary = new HashSet<>();
        for (String line : lines) {
            dictionary.add(line.trim().toLowerCase());
        }
        return dictionary;
    }
}

