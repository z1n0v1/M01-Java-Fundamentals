/*
    https://judge.softuni.org/Contests/Practice/Index/1260#0

    01. Sign of Integer Numbers

Create a method that prints the sign of an integer number.
 */

package L04Methods.Lab.T01SignOfIntegerNumbers;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        printSignOfInteger(Integer.parseInt(scanner.nextLine()));
    }
    private   static void printSignOfInteger(int integer) {
        if (integer > 0)
            System.out.printf("The number %d is positive.%n",integer);
        else if (integer == 0)
            System.out.println("The number 0 is zero.");
        else System.out.printf("The number %d is negative.", integer);
    }
}
