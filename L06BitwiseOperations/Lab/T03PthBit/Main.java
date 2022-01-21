/*
    Write a program that prints the bit at position p of given integer.
    We use the standard counting: from right to left, starting from 0.

    Hints
1.	Declare three variables (n, p and bitAtPositionP).
2.	Read the user input from the console.
3.	Find the value of the bit at position p:
a.	Shift the number p times to the right (where p is the position) by using the >> operator.
    In that way the bit we want to check will be at position 0;
b.	Find the bit at position 0. Use & 1 operator expression to extract the value of a bit.
    By using the following formula (bitAtPositionP & 1) you check whether the bit at position 0 is equal to 1 or not.
    If the bit is equal to 1 the result is 1 if the bit is not equal - the result is 0;
c.	Save the result in bitAtPosition1;
4.	Print the result on the console.

 */

package L06BitwiseOperations.Lab.T03PthBit;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int p = Integer.parseInt(scanner.nextLine());

        if (((n >> p) & 1) == 1)
            System.out.println(1);
        else System.out.println(0);
    }
}
