/*
    https://judge.softuni.org/Contests/Practice/Index/1294#2

    03. Longer Line

You are given the coordinates of four points in the 2D plane. The first and the second pair of points form two different lines.
Print the longer line in format "(X1, Y1)(X2, Y2)" starting with the point that is closer to the center of the
coordinate system (0, 0) (You can reuse the method that you wrote for the previous problem).
If the lines are of equal length, print only the first one.
 */

package L04Methods.Exercise.More.T03LongerLine;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double x1 = Double.parseDouble(scanner.nextLine());
        double y1 = Double.parseDouble(scanner.nextLine());
        double x2 = Double.parseDouble(scanner.nextLine());
        double y2 = Double.parseDouble(scanner.nextLine());
        double x3 = Double.parseDouble(scanner.nextLine());
        double y3 = Double.parseDouble(scanner.nextLine());
        double x4 = Double.parseDouble(scanner.nextLine());
        double y4 = Double.parseDouble(scanner.nextLine());

        double length1 = distance(x1, y1, x2, y2);
        double length2 = distance(x3, y3, x4, y4);

        if (length1 >= length2) {
            if (distance(0, 0, x1, y1) < distance(0, 0, x2, y2))
                System.out.printf("(%.0f, %.0f)(%.0f, %.0f)%n", x1, y1, x2, y2);
            else System.out.printf("(%.0f, %.0f)(%.0f, %.0f)%n", x2, y2, x1, y1);
        } else {
            if (distance(0, 0, x3, y3) < distance(0, 0, x4, y4))
                System.out.printf("(%.0f, %.0f)(%.0f, %.0f)%n", x3, y3, x4, y4);
            else System.out.printf("(%.0f, %.0f)(%.0f, %.0f)%n", x4, y4, x3, y3);
        }


    }

    private static double distance(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
    }
}
