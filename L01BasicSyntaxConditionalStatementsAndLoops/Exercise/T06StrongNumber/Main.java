/*
    https://judge.softuni.org/Contests/Practice/Index/1226#5

    06. Strong Number

Write a program to check if a given number is a strong number or not.
A number is strong if the sum of the Factorial of each digit is equal to the number.
For example 145 is a strong number, because 1! + 4! + 5! = 145.
Print "yes" if the number is strong and "no" if the number is not strong.
 */

package L01BasicSyntaxConditionalStatementsAndLoops.Exercise.T06StrongNumber;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String number = scanner.nextLine();

        int sum = 0;
        for (int i = 0; i < number.length(); i++) {
            int j = Character.getNumericValue(number.charAt(i));
            sum += factorial(j);
        }

        if (sum == Integer.parseInt(number)) {
            System.out.println("yes");
        } else System.out.println("no");

    }
    private static int factorial (int number) {
        int result = 1;
        for (int i = number; i > 1 ; i--) {
            result*=i;
        }
        return result;
    }
}
