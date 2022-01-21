/*
    https://judge.softuni.org/Contests/Practice/Index/1227#10

    11. Refactor Volume of Pyramid

    You are given a working code that finds the volume of a pyramid.
    However, you should consider that the variables exceed their optimum span and have improper naming.
    Also, search for variables that have multiple purpose.

    Scanner scanner = new Scanner(System.in);
    double dul, sh, V = 0;
    System.out.print("Length: ");
    dul = Double.parseDouble(scanner.nextLine());
    System.out.print("Width: ");
    sh = Double.parseDouble(scanner.nextLine());
    System.out.print("Height: ");
    V = Double.parseDouble(scanner.nextLine());
    V = (dul + sh + V) / 3;
    System.out.printf("Pyramid Volume: %.2f", V);

Hints
•	Reduce the span of the variables by declaring them in the moment they receive a value, not before
•	Rename your variables to represent their real purpose (example: "dul" should become length, etc.)
•	Search for variables that have multiple purpose. If you find any, introduce a new variable.

 */

package L02L08DataTypesAndVariables.Lab.T11RefactorVolumeOfPyramid;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Length: ");
        double length = Double.parseDouble(scanner.nextLine());
        System.out.print("Width: ");
        double width = Double.parseDouble(scanner.nextLine());
        System.out.print("Height: ");
        double height = Double.parseDouble(scanner.nextLine());

        double volume = (length * width * height) / 3;
        System.out.printf("Pyramid Volume: %.2f", volume);
    }
}
