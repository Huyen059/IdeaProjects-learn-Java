package correcter;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            StringBuilder message = new StringBuilder(scanner.nextLine());
            String charToChoose = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "abcdefghijklmnopqrstuvwxyz" + "0123456789";
            Random random = new Random();
            int randomStartIndex = random.nextInt(3);
            for (int i = randomStartIndex; i < message.length(); i += 3) {
                char randomCharacter = charToChoose.charAt(random.nextInt(charToChoose.length()));
                message.setCharAt(i, randomCharacter);
            }
            System.out.println(message.toString());
        }
    }
}
