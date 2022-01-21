/*
    https://judge.softuni.org/Contests/Practice/Index/1294#1

    02. Center Point

You are given the coordinates of two points on a Cartesian coordinate system - X1, Y1, X2 and Y2.
Create a method that prints the point that is closest to the center of the coordinate system (0, 0) in the format (X, Y).
If the points are on a same distance from the center, print only the first one.
 */

package L04Methods.Exercise.More.T02CenterPoint;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double x1 = Double.parseDouble(scanner.nextLine());
        double y1 = Double.parseDouble(scanner.nextLine());
        double x2 = Double.parseDouble(scanner.nextLine());
        double y2 = Double.parseDouble(scanner.nextLine());

        if (distance(0, 0, x1, y1) <= distance(0, 0, x2, y2))
            System.out.printf("(%.0f, %.0f)", x1, y1);
        else System.out.printf("(%.0f, %.0f)", x2, y2);


    }

    private static double distance(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
    }
}
