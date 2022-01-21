/*
    4.	Bit Destroyer

Write a program that sets the bit at position p to 0. Print the resulting integer.

1.	Declare four variables (n, p, mask and newNumber).
2.	Read the user input from the console.
3.	Set the value of the bit at position p to 0:
a.	Shift the number 1, p times to the left (where p is the position) by using the << operator.
    In that way the bit we want to delete will be at position p. Save the resulting value in mask;
b.	Invert the mask (e.g. we move the number 1, 3 times and we get 00001000, after inverting we get 11110111).
c.	Use & mask operator expression to set the value of a number to 0.
    By using the following formulae (n & mask) you copy all the bits of the number and you set the bit at position p to 0;
d.	Save the result in newNumber;
4.	Print the result on the console.

 */

package L06BitwiseOperations.Lab.T04BitDestroyer;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int p = Integer.parseInt(scanner.nextLine());

        int newNumber = (~(1<<p)) & n;
        System.out.println(newNumber);
    }
}
