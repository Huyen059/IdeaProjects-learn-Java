package machine;

import java.util.Scanner;

public class CoffeeMachine {
    public static final String BUY = "buy";
    public static final String FILL = "fill";
    public static final String TAKE = "take";
    public static final String EXIT = "exit";
    public static final String REMAINING = "remaining";
    public static final int ESPRESSO = 1;
    public static final int LATTE = 2;
    public static final int CAPPUCCINO = 3;
    public static final int WATER_PER_ESPRESSO = 250;
    public static final int BEAN_PER_ESPRESSO = 16;
    public static final int PRICE_ESPRESSO = 4;
    public static final int WATER_PER_LATTE = 350;
    public static final int MILK_PER_LATTE = 75;
    public static final int BEAN_PER_LATTE = 20;
    public static final int PRICE_LATTE = 7;
    public static final int WATER_PER_CAPPUCCINO = 200;
    public static final int MILK_PER_CAPPUCCINO = 100;
    public static final int BEAN_PER_CAPPUCCINO = 12;
    public static final int PRICE_CAPPUCCINO = 6;
    public static final String BACK = "back";

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
                if (notEnoughWater(WATER_PER_ESPRESSO) || notEnoughBean(BEAN_PER_ESPRESSO)
                        || notEnoughCup()) {
                    break;
                }
                System.out.println(msg);
                buyEspresso();
                break;
            case LATTE:
                if (notEnoughWater(WATER_PER_LATTE) || notEnoughMilk(MILK_PER_LATTE)
                        || notEnoughBean(BEAN_PER_LATTE) || notEnoughCup()) {
                    break;
                }
                System.out.println(msg);
                buyLatte();
                break;
            case CAPPUCCINO:
                if (notEnoughWater(WATER_PER_CAPPUCCINO) || notEnoughMilk(MILK_PER_CAPPUCCINO)
                        || notEnoughBean(BEAN_PER_CAPPUCCINO) || notEnoughCup()) {
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
        currentWater -= WATER_PER_ESPRESSO;
        currentBean -= BEAN_PER_ESPRESSO;
        currentDisposableCups--;
        currentMoney += PRICE_ESPRESSO;
    }

    public static void buyLatte() {
        currentWater -= WATER_PER_LATTE;
        currentMilk -= MILK_PER_LATTE;
        currentBean -= BEAN_PER_LATTE;
        currentDisposableCups--;
        currentMoney += PRICE_LATTE;
    }

    public static void buyCappuccino() {
        currentWater -= WATER_PER_CAPPUCCINO;
        currentMilk -= MILK_PER_CAPPUCCINO;
        currentBean -= BEAN_PER_CAPPUCCINO;
        currentDisposableCups--;
        currentMoney += PRICE_CAPPUCCINO;
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
