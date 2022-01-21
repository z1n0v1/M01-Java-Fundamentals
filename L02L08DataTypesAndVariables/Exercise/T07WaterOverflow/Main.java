/*
    https://judge.softuni.org/Contests/Practice/Index/1228#6

    07. Water Overflow

You have a water tank with capacity of 255 liters.
On the next n lines, you will receive liters of water, which you have to pour in your tank.
If the capacity is not enough, print “Insufficient capacity!” and continue reading the next line.
 On the last line, print the liters in the tank.

Input
The input will be on two lines:
•	On the first line, you will receive n – the number of lines, which will follow
•	On the next n lines – you receive quantities of water, which you have to pour in the tank

Output
Every time you do not have enough capacity in the tank to pour the given liters, print:
Insufficient capacity!
On the last line, print only the liters in the tank.

Constraints
•	n will be in the interval [1…20]
•	liters will be in the interval [1…1000]

 */

package L02L08DataTypesAndVariables.Exercise.T07WaterOverflow;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numLines = Integer.parseInt(scanner.nextLine());
        int liters = 0;

        for (int numPoured = 0; numPoured < numLines; numPoured++) {
            int pour = Integer.parseInt(scanner.nextLine());
            if (liters + pour > 255)
                System.out.println("Insufficient capacity!");
            else liters += pour;
        }
        System.out.println(liters);
    }
}
