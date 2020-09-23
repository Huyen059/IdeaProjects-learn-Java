import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // put your code here
        double temperatureInCelsius = scanner.nextDouble();
        System.out.println(convertCelsiusToFarenheit(temperatureInCelsius));
    }

    static double convertCelsiusToFarenheit(double temp) {
        return temp * 1.8 + 32;
    }
}