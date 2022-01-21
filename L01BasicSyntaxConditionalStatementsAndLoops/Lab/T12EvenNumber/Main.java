/*
    https://judge.softuni.org/Contests/Practice/Index/1190#11

    12. Even Number

Take as an input an even number and print its absolute value.
If the number is odd, print "Please write an even number." and continue reading numbers.

In  Out
1   Please write an even number.
3   Please write an even number.
6   The number is: 6

 */

package L01BasicSyntaxConditionalStatementsAndLoops.Lab.T12EvenNumber;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        while (number % 2 != 0) {
            System.out.println("Please write an even number.");
            number = Integer.parseInt(scanner.nextLine());
        }
        System.out.printf("The number is: %d",Math.abs(number));
    }
}
