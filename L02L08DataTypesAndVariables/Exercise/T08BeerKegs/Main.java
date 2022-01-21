/*
    https://judge.softuni.org/Contests/Practice/Index/1228#7

    08. Beer Kegs

Write a program, which calculates the volume of n beer kegs.
You will receive in total 3 * n lines. Each three lines will hold information for a single keg.
First up is the model of the keg, after that is the radius of the keg, and lastly is the height of the keg.
Calculate the volume using the following formula: π * r^2 * h.
At the end, print the model of the biggest keg.

Input
You will receive 3 * n lines. Each group of lines will be on a new line:
•	First – model – string.
•	Second –radius – floating-point number
•	Third – height – integer number

Output
Print the model of the biggest keg.

Constraints
•	n will be in the interval [1…10]
•	The radius will be a floating-point number in the interval [1…3.402823E+38]
•	The height will be an integer in the interval [1…2147483647]

 */

package L02L08DataTypesAndVariables.Exercise.T08BeerKegs;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        String biggestModel = "";
        double biggestVolume = 0;
        for (int kegNum = 0; kegNum < n; kegNum++) {
            String model = scanner.nextLine();
            double radius = Double.parseDouble(scanner.nextLine());
            int height = Integer.parseInt(scanner.nextLine());

            double volume = Math.PI * radius * radius * height;

            if (volume > biggestVolume) {
                biggestModel = model;
                biggestVolume = volume;
            }
        }
        System.out.println(biggestModel);
    }
}
