package encryptdecrypt;


public class Main {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        String action = scanner.nextLine().trim();
//        String input = scanner.nextLine().trim();
//        int shiftValue = scanner.nextInt();
        String action = "enc";
        int shiftValue = 0;
        String input = "";

        for (int i = 0; i < args.length - 1; i++) {
            if (args[i].equals("-mode") && !args[i + 1].isEmpty()) {
                action = args[i + 1];
            }

            if (args[i].equals("-key") && !args[i + 1].isEmpty()) {
                shiftValue = Integer.parseInt(args[i + 1]);
            }

            if (args[i].equals("-data") && !args[i + 1].isEmpty()) {
                input = args[i + 1];
            }
        }

        Translator translator = new Translator();
        if ("dec".equals(action)) {
            System.out.println(translator.decrypt(input, shiftValue));
        } else {
            System.out.println(translator.encrypt(input, shiftValue));
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
