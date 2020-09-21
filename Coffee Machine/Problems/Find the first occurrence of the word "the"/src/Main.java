import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int pos = -1;
        for (int i = 0; i < input.length(); i++) {
            if (Character.toLowerCase(input.charAt(i)) != 't') {
                continue;
            }

            if (Character.toLowerCase(input.charAt(i + 1)) == 'h' 
                && Character.toLowerCase(input.charAt(i + 2)) == 'e') {
                pos = i;
                break;
            }
        }

        System.out.println(pos);
    }
}
