/*
    https://judge.softuni.org/Contests/Compete/Index/1673#2

    03. SoftUni Bar Income

Let`s take a break and visit the game bar at SoftUni.
It is about time for the people behind the bar to go home and you are the person who has to draw the line and calculate
the money from the products that were sold throughout the day.
Until you receive a line with text "end of shift" you will be given lines of input.
But before processing that line you have to do some validations first.
Each valid order should have a customer, product, count and a price:
•	Valid customer's name should be surrounded by '%' and must start with a capital letter, followed by lower-case letters
•	Valid product contains any word character and must be surrounded by '<' and '>'
•	Valid count is an integer, surrounded by '|'
•	Valid price is any real number followed by '$'
The parts of a valid order should appear in the order given: customer, product, count and a price.
Between each part there can be other symbols, except ('|', '$', '%' and '.')
For each valid line print on the console: "{customerName}: {product} - {totalPrice}"
When you receive "end of shift" print the total amount of money for the day rounded to 2 decimal places
in the following format: "Total income: {income}".

Input / Constraints
•	Strings that you have to process until you receive text "end of shift".

Output
•	Print all the valid lines in the format "{customerName}: {product} - {totalPrice}"
•	After receiving "end of shift" print the total amount of money for the day rounded to 2 decimal places in the following format: "Total income: {income}"
•	Allowed working time / memory: 100ms / 16MB.

 */

package L10RegularExpressions.Exercise.T03SoftUniBarIncome;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Pattern pattern = Pattern.compile(
                "%(?<name>[A-Z][a-z]*)%[^\\|$%\\.]*<(?<product>\\w+)>[^\\|$%\\.]*\\|(?<count>[0-9]+)"
                        +"\\|[^\\|$%\\.0-9]*(?<price>[0-9]+\\.?[0-9]*)\\$");

        String input = scanner.nextLine();

        double income = 0;
        while (!input.equals("end of shift")) {
            Matcher matcher = pattern.matcher(input);

            if (matcher.find()) {
                String name = matcher.group("name");
                String product = matcher.group("product");
                int count = Integer.parseInt(matcher.group("count"));
                double price = Double.parseDouble(matcher.group("price"));
                double totalProductPrice = price*count;
                income += totalProductPrice;

                System.out.printf("%s: %s - %.2f%n", name, product, totalProductPrice);
            }
            input = scanner.nextLine();
        }
        System.out.printf("Total income: %.2f%n", income);

    }
}
