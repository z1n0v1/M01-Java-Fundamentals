/*
    https://judge.softuni.org/Contests/Practice/Index/2517#0

    01. Computer Store

Write a program that prints you a receipt for your new computer.
You will receive the prices (without tax) of the parts until you receive what type of customer is this - special or regular.
Once you receive the type of the customer you should print the receipt.

The taxes are 20% of each part's price you receive.
If the customer is special, then he has a 10% discount of the price of the total price with taxes.
If a given price is not positive number, you should print "Invalid price!" on the console and continue with the next price.
If total price is equal to zero, you should print "Invalid order!" on the console.

Input
•	You will receive numbers representing prices (without tax) until command "special" or "regular":

Output
•	The receipt should be in the following format:

"Congratulations you've just bought a new computer!
Price without taxes: {total price without taxes}$
Taxes: {total amount of taxes}$
-----------
Total price: {total price with taxes}$"
Constraints
Note: All prices should be displayed to the second digit after the decimal point!
The discount is applied only on the total price.  Discount is only applicable to the final price!
 */

package Exam.E01Mid.T01ComputerStore;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Double totalPrice = 0.0;

        while (!(input.equals("special") || input.equals("regular"))) {
            double price = Double.parseDouble(input);
            if (price < 0)
                System.out.println("Invalid price!");
            else totalPrice+=price;
            input = scanner.nextLine();
        }

        if (totalPrice == 0) {
            System.out.println("Invalid order!");
        } else {
            System.out.println("Congratulations you've just bought a new computer!");
            System.out.printf("Price without taxes: %.2f$%n", totalPrice);
            double taxes = totalPrice*0.2;
            System.out.printf("Taxes: %.2f$%n", taxes);
            System.out.println("-----------");
            double price = totalPrice + taxes;
            if(input.equals("special"))
                price *= 0.9;
            System.out.printf("Total price: %.2f$",price);
        }
    }
}
