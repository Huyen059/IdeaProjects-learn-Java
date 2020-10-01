package encryptdecrypt;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String action = scanner.nextLine().trim();
        String input = scanner.nextLine().trim();
        int shiftValue = scanner.nextInt();
        Translator translator = new Translator();
        switch (action) {
            case "enc":
                System.out.println(translator.encrypt(input, shiftValue));
                break;
            case "dec":
                System.out.println(translator.decrypt(input, shiftValue));
                break;
            default:
                break;
        }
    }
}

class Translator {
    /*
    private final Map<Character, Character> keyPair = new HashMap<>();

    void generateKeyPair(int shiftValue) {
        for (int i = 0; i < 26; i++) {
            String alfabet = "abcdefghijklmnopqrstuvwxyz";
            this.keyPair.put(alfabet.charAt(i), alfabet.charAt((i + shiftValue) % 26));
        }
    }

    String encrypt(String input, int shiftValue) {
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
     */

    String encrypt(String input, int shiftValue) {
        StringBuilder output = new StringBuilder(input);
        for (int i = 0; i < input.length(); i++) {
            output.setCharAt(i, (char) (input.charAt(i) + shiftValue));
        }
        return output.toString();
    }

    String decrypt(String input, int shiftValue) {
        StringBuilder output = new StringBuilder(input);
        for (int i = 0; i < input.length(); i++) {
            output.setCharAt(i, (char) (input.charAt(i) - shiftValue));
        }
        return output.toString();
    }
}
