import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // put your code here
        int[] heights = new int[3];
        for (int i = 0; i < heights.length; i++) {
            heights[i] = scanner.nextInt();
        }

        boolean isOrdered = false;

        if (heights[1] >= heights[0] && heights[2] >= heights[1]
                || heights[1] <= heights[0] && heights[2] <= heights[1]) {
            isOrdered = true;
        }

        System.out.println(isOrdered);
    }
}