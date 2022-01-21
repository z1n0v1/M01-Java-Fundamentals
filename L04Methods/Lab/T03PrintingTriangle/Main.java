/*
    https://judge.softuni.org/Contests/Practice/Index/1260#2

    03. Printing Triangle

Create a method for printing triangles as shown below
In : 3
1
1 2
1 2 3
1 2
1
 */

package L04Methods.Lab.T03PrintingTriangle;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        printTriangle(Integer.parseInt(scanner.nextLine()));

    }

    private static void printLine(int start, int end) {
        for (int i = start; i <= end; i++) {
            System.out.printf("%d ", i);
        }
        System.out.println();
    }

    private static void printTriangle(int length) {
        for (int i = 1; i < length; i++) {
            printLine(1, i);
        }
        for (int i = length; i > 0; i--) {
            printLine(1, i);
        }
    }
}
