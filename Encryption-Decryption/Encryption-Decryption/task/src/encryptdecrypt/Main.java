package encryptdecrypt;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().trim();
        int shiftValue = scanner.nextInt();
        Encryption encryption = new Encryption();
        System.out.println(encryption.encryption(input, shiftValue));
    }
}

class Encryption {
    private final Map<Character, Character> keyPair = new HashMap<>();

    void generateKeyPair(int shiftValue) {
        for (int i = 0; i < 26; i++) {
            String alfabet = "abcdefghijklmnopqrstuvwxyz";
            this.keyPair.put(alfabet.charAt(i), alfabet.charAt((i + shiftValue) % 26));
        }
    }

    String encryption(String input, int shiftValue) {
        this.generateKeyPair(shiftValue);
        StringBuilder output = new StringBuilder(input);
        for (int i = 0; i < input.length(); i++) {
            if (!Character.isLetter(input.charAt(i))) {
                continue;
            }
            output.setCharAt(i, this.keyPair.get(input.charAt(i)));
        }
        return output.toString();
    }
}
