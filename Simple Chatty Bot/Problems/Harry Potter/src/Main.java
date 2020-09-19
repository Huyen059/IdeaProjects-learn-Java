import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        String msg = "";
        switch (input) {
            case "gryffindor":
                msg = "bravery";
                break;
            case "hufflepuff":
                msg = "loyalty";
                break;
            case "slytherin":
                msg = "cunning";
                break;
            case "ravenclaw":
                msg = "intellect";
                break;
            default:
                msg = "not a valid house";
                break;
        }

        System.out.println(msg);
    }
}
