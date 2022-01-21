/*
    2.	Bit at Position 1

Write a program that prints the bit at position 1 of given integer.
We use the standard counting: from right to left, starting from 0.

Hints
	Declare two variables (n and bitAtPosition1).
	Read the user input from the console.
	Find the value of the bit at position 1 (position 1 is the second bit from right to left: [7, 6, 5, 4, 3, 2, 1, 0]):
	Shift the number n times to the right (where n is the position, in this case it is 1) by using the >> operator.
	In that way the bit we want to check will be at position 0;
	Find the bit at position 0. Use & 1 operator expression to extract the value of a bit.
	By using the following formulae (bitAtPosition1 & 1) you check whether the bit at position 0 is equal to 1 or not.
	If the bit is equal to 1 the result is 1 if the bit is not equal - the result is 0;
	Save the result in bitAtPosition1;
	Print the result on the console.
 */

package L06BitwiseOperations.Lab.T02BitAtPosition1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int bitAtPosition1 = (n>>1) & 1;
        if(bitAtPosition1 == 1)
            System.out.println(1);
        else System.out.println(0);
    }
}
