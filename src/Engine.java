import java.util.Scanner;

public class Engine {
    private final static Scanner scanner = new Scanner(System.in);
    private static Cipher cipher;

    public static void start() {
        cipher = new Cipher(Constants.ALPHABET);
        System.out.println("\n\nДобро пожаловать в криптоанализатор!\n");

        while (true) {
            printMenu();
            int operation = Integer.parseInt(scanner.nextLine());// обработать ошибку
            switch (operation) {
                case 0 -> exit();
                case 1 -> startEncrypt();
                case 2 -> startDecrypt();
                case 3 -> startBruteForce();
            }
        }
    }

    private static void printMenu() {
        System.out.println("Список операций:");
        System.out.println("1. Шифрование");
        System.out.println("2. Расшифровка с ключом");
        System.out.println("3. BruteForce");
        System.out.println("0. Выход\n");
        System.out.println("Введите код операции: ");
    }

    private static void exit() {
        System.out.println("До свидания!");
        System.exit(0);
    }

    private static void startEncrypt() {
        String inputPath = getFilePath();

        int key = 0;
        do {
            System.out.println("Введите ключ");
            try {
                key = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Введите корректный ключ");
            }
        } while (!Validator.isValidKey(key, Constants.ALPHABET));


        System.out.println("Введите путь файла для сохранения");
        String outputPath = scanner.nextLine();

        String text = FileManager.readFile(inputPath);
        String content = cipher.encrypt(text, key);
        FileManager.writeFile(content, outputPath);
        System.out.println("Операция успешно завершена");
    }

    private static void startDecrypt() {
        String inputPath = getFilePath();

        int key = 0;
        do {
            System.out.println("Введите ключ");
            try {
                key = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Введите корректный ключ");
            }
        } while (!Validator.isValidKey(key, Constants.ALPHABET));


        System.out.println("Введите путь файла для сохранения");
        String outputPath = scanner.nextLine();

        String text = FileManager.readFile(inputPath);
        String content = cipher.decrypt(text, key);
        FileManager.writeFile(content, outputPath);
        System.out.println("Операция успешно завершена");
    }

    private static void startBruteForce() {
        String inputPath = getFilePath();

        System.out.println("Введите путь файла для сохранения");
        String outputPath = scanner.nextLine();

        String dictionaryPath = "";
        do {
            System.out.println("Введите путь файла словаря");
            dictionaryPath = scanner.nextLine();
        } while (!Validator.isFileExists(dictionaryPath));

        String text = FileManager.readFile(inputPath);
        String content = BruteForce.decryptByBruteForce(text, Constants.ALPHABET, BruteForce.loadDictionary(dictionaryPath));
        FileManager.writeFile(content, outputPath);
        System.out.println("Операция успешно завершена");
    }

    private static String getFilePath() {
        String inputPath = "";
        do {
            System.out.println("Введите путь файла с данными");
            inputPath = scanner.nextLine();
        } while (!Validator.isFileExists(inputPath));
        return inputPath;
    }


}

