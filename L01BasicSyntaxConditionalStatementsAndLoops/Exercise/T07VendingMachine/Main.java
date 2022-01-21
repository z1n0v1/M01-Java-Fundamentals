/*
    https://judge.softuni.org/Contests/Practice/Index/1226#6

    07. Vending Machine

You task is to calculate the total price of a purchase from a vending machine.
Until you receive "Start" you will be given different coins that are being inserted in the machine.
You have to sum them in order to have the total money inserted.

There is a problem though. Your vending machine only works with 0.1, 0.2, 0.5, 1, and 2 coins.
If someone tries to insert some other coins you have to display "Cannot accept {money}",
where the value is formated to the second digit after the decimal point and not add it to the total money.
On the next few lines until you receive "End" you will be given products to purchase.

Your machine has however only "Nuts", "Water", "Crisps", "Soda", "Coke". The prices are: 2.0, 0.7, 1.5, 0.8, 1.0 respectively.
If the person tries to purchase a not existing product print “Invalid product”.

Be careful that the person may try to purchase a product for which he doesn't have money.
In that case print "Sorry, not enough money". If the person purchases a product successfully print "Purchased {product name}".
After the “End” command print the money that are left formatted to the second decimal point in the format "Change: {money left}".
 */

package L01BasicSyntaxConditionalStatementsAndLoops.Exercise.T07VendingMachine;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Could use pennies to escape from floating point rounding errors.
        double money = 0;

        String coinString = scanner.nextLine();

        while (!coinString.equals("Start")) {
            double coins = Double.parseDouble(coinString);
            if ( coins == 0.1 || coins == 0.2 || coins == 0.5 || coins == 1 || coins == 2 )
                money += coins;
            else System.out.printf("Cannot accept %.2f%n", coins);
            coinString = scanner.nextLine();
        }

        String order = scanner.nextLine();

        while (!order.equals("End")) {

            switch (order) {
                case "Nuts": {
                    if (money >= 2.00) {
                        money -= 2.00;
                        System.out.println("Purchased " + order);
                    } else {
                        System.out.println("Sorry, not enough money");
                    }
                    break;
                }
                case "Water": {
                    if (money >= 0.70) {
                        money -= 0.70;
                        System.out.println("Purchased " + order);
                    } else {
                        System.out.println("Sorry, not enough money");
                    }
                    break;
                }
                case "Crisps": {
                    if (money >= 1.50) {
                        money -= 1.50;
                        System.out.println("Purchased " + order);
                    } else {
                        System.out.println("Sorry, not enough money");
                    }
                    break;
                }
                case "Soda": {
                    if (money >= 0.80) {
                        money -= 0.80;
                        System.out.println("Purchased " + order);
                    } else {
                        System.out.println("Sorry, not enough money");
                    }
                    break;
                }
                case "Coke": {
                    if (money >= 1.00) {
                        money -= 1.00;
                        System.out.println("Purchased " + order);
                    } else {
                        System.out.println("Sorry, not enough money");
                    }
                    break;
                }

                default:
                    System.out.println("Invalid product");
            }
            order = scanner.nextLine();
        }
        System.out.printf("Change: %.2f", money );


    }
}
