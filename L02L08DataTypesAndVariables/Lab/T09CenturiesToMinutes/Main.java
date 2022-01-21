/*
    https://judge.softuni.org/Contests/Practice/Index/1227#8

    09. Centuries to Minutes

Write program to enter an integer number of centuries and convert it to years, days, hours and minutes.

Hints
•	Use appropriate data type to fit the result after each data conversion.
•	Assume that a year has 365.2422 days at average (the Tropical year).

 */

package L02L08DataTypesAndVariables.Lab.T09CenturiesToMinutes;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int centuries = Integer.parseInt(scanner.nextLine());

        double years = centuries * 100.0;
        double days = years * 365.2422;
        double hours = days * 24;
        double minutes = hours * 60;

        System.out.printf("%d centuries = %.0f years = %.0f days = %.0f hours = %.0f minutes",
                centuries, years, days, hours, minutes);
    }
}
