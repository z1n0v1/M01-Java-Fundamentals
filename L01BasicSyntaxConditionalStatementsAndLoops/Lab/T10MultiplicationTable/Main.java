/*
    https://judge.softuni.org/Contests/Practice/Index/1190#9

    10. Multiplication Table

You will receive an integer as an input from the console. Print the 10 times table for this integer.
See the examples below for more information.

Output
Print every row of the table in the following format:
{theInteger} X {times} = {product}

Constraints
•	The integer will be in the interval [1…100]

5	5 X 1 = 5
    5 X 2 = 10
    5 X 3 = 15
    5 X 4 = 20
    5 X 5 = 25
    5 X 6 = 30
    5 X 7 = 35
    5 X 8 = 40
    5 X 9 = 45
    5 X 10 = 50

 */

package L01BasicSyntaxConditionalStatementsAndLoops.Lab.T10MultiplicationTable;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int theInteger = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <=10; i++) {
            System.out.printf("%d X %d = %d%n",theInteger,i,i*theInteger);
        }
    }
}
