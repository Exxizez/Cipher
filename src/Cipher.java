import java.util.List;

public class Cipher {

    private List<Character> alphabet;
    public Cipher(List<Character> alphabet) {
        this.alphabet = alphabet;
    }

    /**
     * Логика шифрования
     */
    public String encrypt(String text, int key) {
        StringBuilder sb = new StringBuilder();
        char[] array = text.toLowerCase().toCharArray();
        for (int i = 0; i < text.length(); i++) {
            if (!alphabet.contains(array[i])) {
                continue;
            }
            sb.append(getShiftCharacter(array[i], key));
        }
        return sb.toString();
    }

    /**
     * Логика расшифровки
     */
    public String decrypt(String encryptedText, int key) {
        StringBuilder sb = new StringBuilder();
        char[] array = encryptedText.toLowerCase().toCharArray();
        for (int i = 0; i < array.length; i++) {
            if (!alphabet.contains(array[i])) {
                throw new RuntimeException("Нас взломали!");
            }
            sb.append(getShiftCharacter(array[i], -key));
        }
        return sb.toString();
    }

    /**
     * Получаем символ по ключу
     */
    private char getShiftCharacter(char currentChar, int key) {
        int position = alphabet.indexOf(currentChar);
        int temp = (position + key) % alphabet.size();
        int realPosition = temp >= 0 ? temp : alphabet.size() + temp;
        return alphabet.get(realPosition);
    }
}
