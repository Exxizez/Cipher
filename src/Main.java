public class Main {
    public static void main(String[] args) {
        Cipher cipher = new Cipher(Constants.ALPHABET);
        String str = cipher.encrypt("Привет, я Сталин и хотел козу ночью", 0);
        System.out.println(BruteForce.decryptByBruteForce(str, Constants.ALPHABET, BruteForce.loadDictionary("map.txt")));
        // Логика меню
        // 1. Шифрование
        // 2. Расшифровка с ключом
        // 3. Brute force
        // 4. Статистический анализ
        // 0. Выход

        // Пример вызова метода шифрования:
        // cipher.encrypt("input.txt", "output.txt", 3);

    }
}