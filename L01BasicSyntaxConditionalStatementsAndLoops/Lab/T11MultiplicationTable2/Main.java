/*
    https://judge.softuni.org/Contests/Practice/Index/1190#10

    11. Multiplication Table 2.0

Rewrite you program so it can receive the multiplier from the console.
Print the table from the given multiplier to 10.
If the given multiplier is more than 10 - print only one row with the integer, the given multiplier and the product.
See the examples below for more information.

Output
Print every row of the table in the following format:
{theInteger} X {times} = {product}

Constraints
•	The integer will be in the interval [1…100]

2	2 X 14 = 28
14

 */

package L01BasicSyntaxConditionalStatementsAndLoops.Lab.T11MultiplicationTable2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int theInteger = Integer.parseInt(scanner.nextLine());
        int multiplier = Integer.parseInt(scanner.nextLine());

        if (multiplier > 10) {
            System.out.printf("%d X %d = %d%n",theInteger,multiplier,theInteger*multiplier);
        } else {
            for (int i = multiplier; i <=10 ; i++) {
                System.out.printf("%d X %d = %d%n",theInteger,i,i*theInteger);
            }
        }
    }
}
