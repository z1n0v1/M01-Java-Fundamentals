/*
    6.	* Tri-bit Switch

Write a program that inverts the 3 bits from position p to the left with their XOR opposites (e.g. 111 -> 000, 101 -> 010)
in 32-bit number. Print the resulting integer on the console.

Hints
1.	Shift the number 7 (the number 7 has the bits 111 which we use to get 3 consecutive values),
    p times to the left (where p is the position) by using the << operator.
    In that way the 3 bits we want to invert will be at position p. Save the resulting value in mask;
2.	Use ^ mask operator expression to invert the values of the three bits starting from position p.
    By using the following formulae (n ^ mask) you copy all the bits of the number
    and you invert the bits at position p, p+1 and p+2;
3.	Save the result in result;
 */

package L06BitwiseOperations.Lab.T06TriBitSwitch;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        int p = Integer.parseInt(scanner.nextLine());

        int mask = (7 << p);
        System.out.println(number^mask);
    }
}
