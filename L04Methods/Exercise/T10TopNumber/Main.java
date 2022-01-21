/*
    https://judge.softuni.org/Contests/Practice/Index/1286#9

    10. Top Number

Read an integer n from the console. Find all top numbers in the range [1 … n] and print them.
A top number holds the following properties:
•	Its sum of digits is divisible by 8, e.g. 8, 16, 88.
•	Holds at least one odd digit, e.g. 232, 707, 87578.

 */

package L04Methods.Exercise.T10TopNumber;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <=n ; i++) {

            if ( hasOddDigit(i) && (digitsSum(i) % 8 == 0))
                System.out.println(i);
        }
    }

    private static boolean hasOddDigit(int num) {
        while (num != 0) {
            if((num % 10) % 2 == 1)
                return true;
            num /= 10;
        }
        return false;
    }

    private static int digitsSum(int num) {
        int sum = 0;

        while (num != 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}
