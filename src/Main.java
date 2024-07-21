public class Main {
    public static void main(String[] args) {
        Cipher cipher = new Cipher(Constants.ALPHABET);
        System.out.println(cipher.encrypt("привет!!!", 45));
    }
}