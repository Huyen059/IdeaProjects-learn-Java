package correcter;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        try (Scanner scanner = new Scanner(System.in)) {
//            StringBuilder message = new StringBuilder(scanner.nextLine());
//            System.out.println(message.toString());
//            StringBuilder messageToSend = tripleCharacter(message);
//            System.out.println(messageToSend);
//            StringBuilder encodedMessage = encode(messageToSend);
//            System.out.println(encodedMessage.toString());
//            StringBuilder originalMessage = decode(encodedMessage);
//            System.out.println(originalMessage);
//        }
        int[] message = new int[] {114, 101, 97, 100, 32, 97, 98, 111, 117, 116, 32, 65, 83, 67, 73, 73};

//        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
//        for (int code : message) {
//            outputStream.write(code);
//        }
//
//        System.out.println(outputStream.toString());
    }

    static StringBuilder tripleCharacter(StringBuilder message) {
        StringBuilder messageToSend = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            messageToSend.append(String.valueOf(message.charAt(i)).repeat(3));
        }
        return messageToSend;
    }

    static StringBuilder encode(StringBuilder message) {
        String charToChoose = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "abcdefghijklmnopqrstuvwxyz" + "0123456789";
        Random random = new Random();
        int randomStartIndex = random.nextInt(3);
        for (int i = randomStartIndex; i < message.length(); i += 3) {
            char randomCharacter = charToChoose.charAt(random.nextInt(charToChoose.length()));
            if (randomCharacter == message.charAt(i)) {
                randomCharacter++;
            }
            message.setCharAt(i, randomCharacter);
        }
        return message;
    }

    static StringBuilder decode(StringBuilder message) {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < message.length(); i += 3) {
            if (message.charAt(i) == message.charAt(i + 1) || message.charAt(i) == message.charAt(i + 2)) {
                output.append(message.charAt(i));
                continue;
            }

            output.append(message.charAt(i + 1));
        }
        return output;
    }
}
