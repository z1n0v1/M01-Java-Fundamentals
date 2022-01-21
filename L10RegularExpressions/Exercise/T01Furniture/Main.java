/*
    https://judge.softuni.org/Contests/Compete/Index/1673#0

    01. Furniture

Write a program to calculate the total cost of different types of furniture.
You will be given some lines of input until you receive the line "Purchase".
For the line to be valid it should be in the following format:
">>{furniture name}<<{price}!{quantity}"
The price can be a floating-point number or a whole number.
Store the names of the furniture and the total price.
At the end print each bought furniture on a separate line in the format:
"Bought furniture:
{1st name}
{2nd name}
…"
And on the last line print the following: "Total money spend: {spend money}" formatted to the second decimal point.
 */

package L10RegularExpressions.Exercise.T01Furniture;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String regex = "^\\>{2}(?<furniture>[a-zA-Z]+)\\<{2}\\b(?<price>[0-9]+\\.?[0-9]*)!(?<quantity>[0-9]*)\\b";
        Pattern furniturePattern = Pattern.compile(regex);

        double totalPrice = 0;

        String input = scanner.nextLine();

        System.out.println("Bought furniture:");
        while (!input.equals("Purchase")) {
            Matcher furnMatcher = furniturePattern.matcher(input);

            if (furnMatcher.find()) {
                String name = furnMatcher.group("furniture");
                double price = Double.parseDouble(furnMatcher.group("price"));
                int quantity = Integer.parseInt(furnMatcher.group("quantity"));
                System.out.println(name);
                totalPrice+= price * quantity;
            }
            input = scanner.nextLine();
        }
        System.out.printf("Total money spend: %.2f", totalPrice);
    }
}
