import java.util.List;

public class Cipher {
    private List<Character> alphabet;

    public Cipher(List<Character> alphabet) {
        this.alphabet = alphabet;
    }

    public String encrypt(String text, int shift) {
        // Логика шифрования
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (!alphabet.contains(ch)) {
                continue;
            }
            int position = alphabet.indexOf(ch);
            char newChar = alphabet.get((position + shift) % alphabet.size());
            sb.append(newChar);
        }
        return sb.toString();
    }

    public String decrypt(String encryptedText, int shift) {
        // Логика расшифровки
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < encryptedText.length(); i++) {
            char ch = encryptedText.charAt(i);
            if (!alphabet.contains(ch)) {
                throw new RuntimeException("Нас взломали!");
            }

            int position = alphabet.indexOf(ch);
            int temp = (position - shift) % alphabet.size();
            int realPosition = temp >= 0 ? temp : alphabet.size() + temp;
            char newChar = alphabet.get(realPosition);

            sb.append(newChar);
        }
        return sb.toString();
    }
}
