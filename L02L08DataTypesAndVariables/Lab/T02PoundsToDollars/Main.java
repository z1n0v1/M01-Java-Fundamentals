/*
    https://judge.softuni.org/Contests/Practice/Index/1227#1

    02. Pounds to Dollars

Write a program that converts British pounds to US dollars formatted to 3th decimal point.
1 British Pound = 1.31 Dollars

 */

package L02L08DataTypesAndVariables.Lab.T02PoundsToDollars;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int pounds = Integer.parseInt(scanner.nextLine());
        double dollars = pounds * 1.31;
        System.out.printf("%.3f", dollars);
    }
}
