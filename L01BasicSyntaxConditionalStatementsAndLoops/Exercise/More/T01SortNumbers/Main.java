/*
    https://judge.softuni.org/Contests/Practice/Index/1461#0

    01. Sort Numbers

 Read three real numbers and sort them in descending order. Print each number on a new line.
 */

package L01BasicSyntaxConditionalStatementsAndLoops.Exercise.More.T01SortNumbers;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double[] n = {Double.parseDouble(scanner.nextLine()),
                Double.parseDouble(scanner.nextLine()),
                Double.parseDouble(scanner.nextLine())};

        Arrays.sort(n);

        for (int i = n.length - 1; i >= 0 ; i--) {
            System.out.printf("%.0f%n",n[i]);

        }
    }
}
