/*
    https://judge.softuni.org/Contests/Practice/Index/1227#2

    03. Exact Sum of Real Numbers

Write program to enter n numbers and calculate and print their exact sum (without rounding).
 */

package L02L08DataTypesAndVariables.Lab.T03ExactSumOfRealNumbers;

import java.math.BigDecimal;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numNumbers = Integer.parseInt(scanner.nextLine());

        BigDecimal sum = new BigDecimal(0);
        for (int i = 0; i < numNumbers; i++) {
            BigDecimal number = new BigDecimal(scanner.nextLine());
            sum = sum.add(number);
        }
        System.out.println(sum);
    }
}
