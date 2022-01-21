/*
    1.	Binary Digits Count

You are given a positive integer number and one binary digit B (0 or 1).
Your task is to write a program that finds the number of binary digits (B) in given integer.

Hints
1.	Declare two variables (n and b).
2.	Read the user input from the console.
3.	Convert the n into binary representation (you can use built-in method).
4.	Count the b digit in the binary number.
5.	Print the result on the console.
 */

package L06BitwiseOperations.Lab.T01BinaryDigitsCount;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Integer number = Integer.parseInt(scanner.nextLine());
        char binaryNum = scanner.nextLine().charAt(0);
        String intInBinary = Integer.toBinaryString(number);

        int symbolSum = 0;

        for (int i = 0; i < intInBinary.length(); i++) {
            if ( intInBinary.charAt(i) == binaryNum)
                symbolSum++;
        }
        System.out.println(symbolSum);
    }
}
