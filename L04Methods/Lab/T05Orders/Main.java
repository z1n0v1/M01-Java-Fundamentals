/*
    https://judge.softuni.org/Contests/Practice/Index/1260#4

    05. Orders

Write a method that calculates the total price of an order and prints it on the console.
The method should receive one of the following products: coffee, water, coke, snacks; and a quantity of the product.
The prices for a single piece of each product are:
•	coffee – 1.50
•	water – 1.00
•	coke – 1.40
•	snacks – 2.00
Print the result rounded to the second decimal place.
 */

package L04Methods.Lab.T05Orders;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String product = scanner.nextLine();
        int quantity = Integer.parseInt(scanner.nextLine());
        printBill(product,quantity);
    }

    private static void printBill(String product, int quantity) {
        switch (product) {
            case "coffee":
                System.out.printf("%.2f", 1.5 * quantity);
                break;
            case "water":
                System.out.printf("%.2f", 1.0 * quantity);
                break;
            case "coke":
                System.out.printf("%.2f", 1.4 * quantity);
                break;
            case "snacks":
                System.out.printf("%.2f", 2.00 * quantity);
        }
    }
}
