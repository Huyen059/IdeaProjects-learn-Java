package encryptdecrypt;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String input = "we found a treasure!";
        var encryption = new Encryption();
        encryption.generateKeyPair();
        System.out.println(encryption.encrypt(input));

    }
}

class Encryption {
    private Map<Character, Character> keyPair = new HashMap<>();

    void generateKeyPair() {
        generateKeyPair(1);
    }

    void generateKeyPair(int shiftValue) {
        char key = 'a';
        char value = 'z';
        for (int i = 0; i < 26; i++) {
            this.keyPair.put(key, value);
            for (int j = 0; j < shiftValue; j++) {
                key++;
                value--;
            }
        }
    }

    String encrypt(String input) {
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