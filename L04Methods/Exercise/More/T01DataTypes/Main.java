/*
    https://judge.softuni.org/Contests/Practice/Index/1294#0

    01. Data Types

Write a program that, depending on the first line of the input, reads an int, double or string.
•	If the data type is int, multiply the number by 2.
•	If the data type is real, multiply the number by 1.5 and format it to the second decimal point.
•	If the data type is string, surround the input with "$".
Print the result on the console.

Hint
Try to solve the problem using only one method with different overloads.
 */

package L04Methods.Exercise.More.T01DataTypes;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String type = scanner.nextLine();
        String data = scanner.nextLine();

        switch (type) {
            case "int": {
                System.out.println(calculate(Integer.parseInt(data)));
                break;
            }
            case "real": {
                System.out.printf("%.2f%n", calculate(Double.parseDouble(data)));
                break;
            }
            case "string" : {
                System.out.println(calculate(data));
                break;
            }
        }
    }

    private static int calculate(int a) {
        return a * 2;
    }

    private static double calculate(double a) {
        return a * 1.5;
    }

    private static String calculate(String a) {
        return "$" + a + "$";
    }
}
