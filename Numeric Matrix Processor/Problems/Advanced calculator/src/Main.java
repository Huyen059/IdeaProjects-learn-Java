import java.util.Arrays;

/* Please, do not rename it */
class Problem {

    public static void main(String[] args) {
        String operator = args[0];
        // write your code here
        int[] numbers = Arrays.stream(args).skip(1)
                .mapToInt(Integer::parseInt)
                .toArray();
        Arrays.sort(numbers);
        switch (operator) {
            case "MAX":
                System.out.println(numbers[numbers.length - 1]);
                break;
            case "MIN":
                System.out.println(numbers[0]);
                break;
            case "SUM":
                System.out.println(Arrays.stream(numbers).sum());
                break;
            default:
                break;
        }
    }
}
