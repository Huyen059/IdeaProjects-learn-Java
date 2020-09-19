import java.util.Scanner;
class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        String form = scanner.next();
        switch (form) {
            case "triangle":
                double a = scanner.nextDouble();
                double b = scanner.nextDouble();
                double c = scanner.nextDouble();

                double s = (a + b + c) / 2;
                System.out.println(Math.sqrt(s * (s - a) * (s - b) * (s - c)));
                break;
            case "rectangle":
                System.out.println(scanner.nextDouble() * scanner.nextDouble());
                break;
            case "circle":
                double r = scanner.nextDouble();
                System.out.println(r * r * 3.14);
                break;
                
            default:
                break;
        }
    }
}
