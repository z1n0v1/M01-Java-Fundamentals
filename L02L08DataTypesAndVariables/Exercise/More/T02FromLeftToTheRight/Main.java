/*
    https://judge.softuni.org/Contests/Practice/Index/1270#1

    02. From Left to The Right

You will receive a number which represents how many lines we will get as an input.
On the next N lines, you will receive a string with 2 numbers separated by a single space. You need to compare them.
If the left number is greater than the right number, you need to print the sum of all digits in the left number,
otherwise print the sum of all digits in the right number.
 */

package L02L08DataTypesAndVariables.Exercise.More.T02FromLeftToTheRight;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numLines = Integer.parseInt(scanner.nextLine());

        for (int numLine = 0; numLine < numLines ; numLine++) {

            long n1 = scanner.nextLong();
            long n2 = scanner.nextLong();

            if (n1 > n2) System.out.println(sumDigits(Math.abs(n1)));
            else System.out.println(sumDigits(Math.abs(n2)));
        }
    }
    private static int sumDigits(long number) {
        int sum = 0;
        while (number != 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }
}
