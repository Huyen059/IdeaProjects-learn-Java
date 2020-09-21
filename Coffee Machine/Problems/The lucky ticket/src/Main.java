import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        char[] inputAsCharArray = input.toCharArray();
        int size = inputAsCharArray.length;
        int sumBegin = 0;
        int sumEnd = 0;
        for (int i = 0; i < 3; i++) {
            sumBegin += inputAsCharArray[i];
            sumEnd += inputAsCharArray[size - 1 - i];
        }

        if (sumBegin == sumEnd) {
            System.out.println("Lucky");
        } else {
            System.out.println("Regular");
        }
    }
}