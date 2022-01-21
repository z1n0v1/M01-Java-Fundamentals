/*
    https://judge.softuni.org/Contests/Practice/Index/1260#7

    08. Math Power

Create a method that calculates and returns the value of a number raised to a given power.
 */

package L04Methods.Lab.T08MathPower;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double value = Double.parseDouble(scanner.nextLine());
        int power = Integer.parseInt(scanner.nextLine());

        System.out.println(new DecimalFormat("0.####").format(power(value,power)));
    }

    private static double power(double value, int power) {
        double result = value;

        // or return Math.pow(value,power);
        for (int i = 1; i < power; i++) {
            result*= value;
        }
        return result;
    }
}
