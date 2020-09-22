import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        StringBuilder output = new StringBuilder();
        while (scanner.hasNext()) {
            String input = scanner.next();
            try {
                int number = Integer.parseInt(input);
                if (number == 0) {
                    break;
                }
                output.append(Integer.parseInt(input) * 10).append("\n");
            } catch (Exception e) {
                output.append("Invalid user input: ").append(input).append("\n");
            }
        }
        System.out.println(output);
    }
}