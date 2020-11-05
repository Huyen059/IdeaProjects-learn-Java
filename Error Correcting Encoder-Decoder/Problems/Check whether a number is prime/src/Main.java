import java.util.Scanner;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ExecutorService executor = Executors.newFixedThreadPool(4); // assign an object to it

        while (scanner.hasNext()) {
            int number = scanner.nextInt();
            Runnable task = new PrintIfPrimeTask(number);
            task.run();
        }

        executor.shutdown();

    }
}

class PrintIfPrimeTask implements Runnable {
    private final int number;

    public PrintIfPrimeTask(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        if (number <= 1) {
            return;
        }

        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return;
            }
        }
        System.out.println(number);
    }
}
