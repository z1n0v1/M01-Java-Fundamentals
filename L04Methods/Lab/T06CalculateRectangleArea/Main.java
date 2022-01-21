/*
    https://judge.softuni.org/Contests/Practice/Index/1260#5

    06. Calculate Rectangle Area

Create a method that calculates and returns the area of a rectangle by given width and length.
 */

package L04Methods.Lab.T06CalculateRectangleArea;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double x = Double.parseDouble(scanner.nextLine());
        double y = Double.parseDouble(scanner.nextLine());
        double area = rectangularArea(x, y);
        System.out.printf("%.0f", area);
    }

    private static double rectangularArea(double x, double y) {
        return x * y;
    }
}
