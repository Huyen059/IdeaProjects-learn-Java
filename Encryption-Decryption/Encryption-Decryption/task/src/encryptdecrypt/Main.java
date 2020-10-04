/*

package encryptdecrypt;


import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        String action = scanner.nextLine().trim();
//        String input = scanner.nextLine().trim();
//        int shiftValue = scanner.nextInt();
        String action = "enc";
        int shiftValue = 0;
        String input = "";
        String inputFileName = "";
        String outputFileName = "";

        for (int i = 0; i < args.length - 1; i += 2) {
            if (args[i].equals("-mode") && !args[i + 1].isEmpty()) {
                action = args[i + 1];
            }

            if (args[i].equals("-key") && !args[i + 1].isEmpty()) {
                shiftValue = Integer.parseInt(args[i + 1]);
            }

            if (args[i].equals("-data") && !args[i + 1].isEmpty()) {
                input = args[i + 1];
            }


            if (args[i].equals("-in") && !args[i + 1].isEmpty()) {
                inputFileName = args[i + 1];
            }

            if (args[i].equals("-out") && !args[i + 1].isEmpty()) {
                outputFileName = args[i + 1];
            }
        }

        if (!isInputReadFromStandardInput(input, inputFileName)) {
            try {
                input = readFromFile(inputFileName);
            } catch (IOException e) {
                e.getStackTrace();
            }
        }

        String result = translate(action, input, shiftValue);

        if (isOutputToStandardOutput(outputFileName)) {
            System.out.println(result);
        } else {
            try {
                writeToFile(result, outputFileName);
            } catch (IOException e) {
                e.getStackTrace();
            }
        }
    }

    static String translate(String action, String input, int shiftValue) {
        Translator translator = new Translator();
        if (action.equals("dec")) {
            return translator.decrypt(input, shiftValue);
        } else {
            return translator.encrypt(input, shiftValue);
        }
    }

    static String readFromFile(String fileName) throws IOException {
        return new String(Files.readAllBytes(Paths.get(fileName)));
    }

    static void writeToFile(String content, String fileName) throws IOException {
        File file = new File(fileName);
        PrintWriter printer = new PrintWriter(file);
        printer.println(content);
        printer.close();
    }

    static boolean isInputReadFromStandardInput(String input, String inputFileName) {
        if (input.isEmpty() && inputFileName.isEmpty()) {
            return true;
        }

        if (!input.isEmpty() && !inputFileName.isEmpty()) {
            return true;
        }

        return !input.isEmpty();
    }

    static boolean isOutputToStandardOutput(String outputFileName) {
        return outputFileName.isEmpty();
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



READ FILE IN THE PROJECT FOLDER

package com.company;

//import java.io.File;
//import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
//import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
    // POSITION OF THE FILE IS RELATIVE TO THE MAIN PROJECT FOLDER, NOT THE SRC FOLDER
        String path = "./dataset_91065.txt";
//        File file = new File(path);
//        try (Scanner scanner = new Scanner(file)) {
//            StringBuilder output = new StringBuilder();
//            while (scanner.hasNext()) {
//                output.append(scanner.next());
//            }
//            System.out.println(output);
//        } catch (FileNotFoundException e) {
//            System.out.println(e.getMessage());
//        }


        try {
            String fileContent = readFileAsString(path);
//            System.out.println(fileContent);
            String[] numbersAsString = fileContent.split("\r\n");
            int count = 0;
            for (String number : numbersAsString) {
                if (number.equals("0")) {
                    break;
                }

                if (Integer.parseInt(number) % 2 == 0) {
                    count++;
                }
            }
            System.out.println(count);
        } catch (IOException e) {
            e.getStackTrace();
        }
    }

    public static String readFileAsString(String path) throws IOException {
        return new String(Files.readString(Paths.get(path)));
    }
}



*/

package encryptdecrypt;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String operation = "enc";
        String text = "";
        int key = 0;
        String in = "";
        String out = "";

        for (int i = 0; i < args.length; i = i + 2) {
            switch (args[i]) {
                case "-mode":
                    operation = args[i + 1];
                    break;
                case "-key":
                    key = Integer.parseInt(args[i + 1]);
                    break;
                case "-data":
                    text = args[i + 1];
                    break;
                case "-in":
                    in = args[i + 1];
                    break;
                case "-out":
                    out = args[i + 1];
                    break;
            }
        }

        if (text.isEmpty() && !in.isEmpty()) {
            text = readFile(in);
        }

        char[] chars = text.toCharArray();
        if (operation.equalsIgnoreCase("enc")) {
            String encryptText = encryptText(key, chars);
            if (out.isEmpty()) {
                System.out.println(encryptText);
            } else {
                writeFile(out, encryptText);
            }
        }
        if (operation.equalsIgnoreCase("dec")) {
            String decryptText = decryptText(key, chars);
            if (out.isEmpty()) {
                System.out.println(decryptText);
            } else {
                writeFile(out, decryptText);
            }
        }

    }

    static String encryptText(int key, char[] chars) {
        StringBuilder encryptText = new StringBuilder();
        for (char aChar : chars) {
            int exc = aChar + key;
            encryptText.append((char) exc);
        }
        return encryptText.toString();
    }

    static String decryptText(int key, char[] chars) {
        StringBuilder decryptText = new StringBuilder();
        for (char aChar : chars) {
            int exc = aChar - key;
            decryptText.append((char) exc);
        }
        return decryptText.toString();

    }

    static String readFile(String fileName) {
        String text = null;
        File file = new File(fileName);
        try {
            Scanner scanner = new Scanner(file);
            text = scanner.nextLine();
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("error");
        }
        return text;

    }

    static void writeFile(String fileName, String text) {
        File file = new File(fileName);
        try {
            FileWriter fileWriter = new FileWriter(file);
            if (file.canWrite()) {
                fileWriter.write(text);
                fileWriter.close();
            }
        } catch (IOException e) {
            System.out.println("error");
        }
    }
}