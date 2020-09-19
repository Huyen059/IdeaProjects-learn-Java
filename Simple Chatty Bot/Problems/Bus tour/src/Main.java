import java.util.*;

public class Main {
    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);
        int busHeight = scanner.nextInt();
        int numberOfBridges = scanner.nextInt();
        String msg = "Will not crash";
        for (int i = 0; i < numberOfBridges; i++) {
            if (scanner.nextInt() <= busHeight) {
                msg = "Will crash on bridge " + (i + 1);
                break;
            }
        }
        System.out.println(msg);
    }
}
