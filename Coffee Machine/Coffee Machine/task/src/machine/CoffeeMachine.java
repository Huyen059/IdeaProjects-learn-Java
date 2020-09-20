package machine;

import java.util.Scanner;

public class CoffeeMachine {
    public static final String BUY = "buy";
    public static final String FILL = "fill";
    public static final String TAKE = "take";
    public static final String REMAINING = "remaining";
    public static final String EXIT = "exit";
    public static final String BACK = "back";
    public static final int ESPRESSO = 1;
    public static final int LATTE = 2;
    public static final int CAPPUCCINO = 3;

    public static Scanner scanner = new Scanner(System.in);
    public static int currentWater;
    public static int currentMilk;
    public static int currentBean;
    public static int currentDisposableCups;
    public static int currentMoney;
    public static boolean goBack = false;

    public static void start() {
        currentMoney = 550;
        currentWater = 400;
        currentMilk = 540;
        currentBean = 120;
        currentDisposableCups = 9;
    }

    public static void displayInfo() {
        System.out.printf("The coffee machine has:\n" +
                        "%d of water\n" +
                        "%d of milk\n" +
                        "%d of coffee beans\n" +
                        "%d of disposable cups\n",
                currentWater, currentMilk,
                currentBean, currentDisposableCups);
        if (currentMoney == 0) {
            System.out.print("0");
        } else {
            System.out.printf("$%d", currentMoney);
        }
        System.out.println(" of money\n");
    }

    public static String getAction() {
        System.out.println("Write action (buy, fill, take, remaining, exit): ");
        return scanner.next();
    }

    public static void handleAction(String action) {
        switch (action) {
            case BUY:
                handleBuy();
                break;
            case FILL:
                handleFill();
                break;
            case TAKE:
                handleTake();
                break;
            case REMAINING:
                displayInfo();
                break;
            case EXIT:
                break;
        }
    }

    public static void handleFill() {
        System.out.println("Write how many ml of water do you want to add:");
        currentWater += scanner.nextInt();
        System.out.println("Write how many ml of milk do you want to add:");
        currentMilk += scanner.nextInt();
        System.out.println("Write how many grams of coffee beans do you want to add:");
        currentBean += scanner.nextInt();
        System.out.println("Write how many disposable cups of coffee do you want to add:");
        currentDisposableCups += scanner.nextInt();
    }

    public static void handleTake() {
        System.out.printf("I gave you $%d\n", currentMoney);
        currentMoney = 0;
    }

    public static void handleBuy() {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");

        if (!scanner.hasNextInt() && scanner.next().equals(BACK)) {
            goBack = true;
            return;
        }

        int typeCoffee = scanner.nextInt();
        String msg = "I have enough resources, making you a coffee!";
        switch (typeCoffee) {
            case ESPRESSO:
                if (notEnoughWater(Coffees.ESPRESSO.waterPerCup) || notEnoughBean(Coffees.ESPRESSO.beanPerCup)
                        || notEnoughCup()) {
                    break;
                }
                System.out.println(msg);
                buyEspresso();
                break;
            case LATTE:
                if (notEnoughWater(Coffees.LATTE.waterPerCup) || notEnoughMilk(Coffees.LATTE.milkPerCup)
                        || notEnoughBean(Coffees.LATTE.beanPerCup) || notEnoughCup()) {
                    break;
                }
                System.out.println(msg);
                buyLatte();
                break;
            case CAPPUCCINO:
                if (notEnoughWater(Coffees.CAPPUCCINO.waterPerCup) || notEnoughMilk(Coffees.CAPPUCCINO.milkPerCup)
                        || notEnoughBean(Coffees.CAPPUCCINO.beanPerCup) || notEnoughCup()) {
                    break;
                }
                System.out.println(msg);
                buyCappuccino();
                break;
        }
    }

    public static boolean notEnoughWater(int waterPerCup) {
        if (currentWater >= waterPerCup) {
            return false;
        }

        System.out.println("Sorry, not enough water!");
        return true;
    }

    public static boolean notEnoughMilk(int milkPerCup) {
        if (currentMilk >= milkPerCup) {
            return false;
        }

        System.out.println("Sorry, not enough milk!");
        return true;
    }

    public static boolean notEnoughBean(int beanPerCup) {
        if (currentBean >= beanPerCup) {
            return false;
        }

        System.out.println("Sorry, not enough bean!");
        return true;
    }

    public static boolean notEnoughCup() {
        if (currentDisposableCups > 0) {
            return false;
        }

        System.out.println("Sorry, not enough disposable cup!");
        return true;
    }

    public static void buyEspresso() {
        currentWater -= Coffees.ESPRESSO.waterPerCup;
        currentBean -= Coffees.ESPRESSO.beanPerCup;
        currentDisposableCups--;
        currentMoney += Coffees.ESPRESSO.price;
    }

    public static void buyLatte() {
        currentWater -= Coffees.LATTE.waterPerCup;
        currentMilk -= Coffees.LATTE.milkPerCup;
        currentBean -= Coffees.LATTE.beanPerCup;
        currentDisposableCups--;
        currentMoney += Coffees.LATTE.price;
    }

    public static void buyCappuccino() {
        currentWater -= Coffees.CAPPUCCINO.waterPerCup;
        currentMilk -= Coffees.CAPPUCCINO.milkPerCup;
        currentBean -= Coffees.CAPPUCCINO.beanPerCup;
        currentDisposableCups--;
        currentMoney += Coffees.CAPPUCCINO.price;
    }

    public static void main(String[] args) {
        start();
        String action = getAction();
        while (!action.equals(EXIT)) {
            handleAction(action);
            action = getAction();
        }
    }
}

enum Coffees {
    ESPRESSO(250, 0, 16, 4),
    LATTE(350, 75, 20, 7),
    CAPPUCCINO(200, 100, 12, 6);

    int waterPerCup;
    int milkPerCup;
    int beanPerCup;
    int price;

    Coffees(int waterPerCup, int milkPerCup, int beanPerCup, int price) {
        this.waterPerCup = waterPerCup;
        this.milkPerCup = milkPerCup;
        this.beanPerCup = beanPerCup;
        this.price = price;
    }
}