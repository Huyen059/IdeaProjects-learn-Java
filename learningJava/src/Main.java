import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //// Get input number, reverse it and print it out
//        int num = scanner.nextInt();
//        String reverseString = new StringBuffer(String.valueOf(num)).reverse().toString();
//        System.out.println(Integer.valueOf(reverseString));

        //// Snail creeps up the vertical pole of height H feet. It goes A feet up per day,
        //// and B feet down per night. In which day the snail will reach the top of the pole?

//        int height = scanner.nextInt();
//        int up = scanner.nextInt();
//        int down = scanner.nextInt();
//        int perDay = up - down;
//        int duration = 1, currentHeight = 0;
//        while (currentHeight + up < height){
//            currentHeight += perDay;
//            duration++;
//        }
//        System.out.println(duration);
        //// Careful of the order
//        int a = -1;
//        System.out.println(1 - a++); //Print 2

//        int[] numbers = new int[4];
//        for (int i = 0; i < 4 ; i++) {
//            numbers[i] = scanner.nextInt();
//            System.out.print(--numbers[i] + " ");
//        }

//        String str = scanner.nextLine().trim();
//        String str2 = scanner.nextLine().trim();
//        System.out.println(str.equals(str2));
//        boolean result = true;
//        Set<Integer> numbers = new HashSet<>();
//        for (int i = 0; i < 3; i++) {
//            if (!numbers.add(scanner.nextInt())) {
//                result = false;
//                break;
//            }
//        }
//        System.out.println(result);
//        int count = 0;
//        for (int i = 0; i < 3; i++) {
//            if(scanner.nextInt() > 0) {
//                count++;
//            }
//        }
//        System.out.println(count == 1);


//        int num = scanner.nextInt();
//
//        String unit = "";
//
//        if (num < 1) {
//            unit = "no army";
//        } else if (num < 20) {
//            unit = "pack";
//        } else if (num < 250) {
//            unit = "throng";
//        } else if (num < 1000) {
//            unit = "zounds";
//        } else {
//            unit = "legion";
//        }
//
//        System.out.println(unit);

//        Output True if its value is within the interval (−15,12]∪(14,17)∪[19,+∞),
//        and False otherwise (case sensitive).
        int num = scanner.nextInt();
        if ((num > -15 && num <= 12) || (num > 14 && num < 17) || (num >= 19)) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }

    }
}
