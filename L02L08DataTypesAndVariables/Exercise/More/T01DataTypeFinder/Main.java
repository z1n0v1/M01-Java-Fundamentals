/*
    https://judge.softuni.org/Contests/Practice/Index/1270#0

    01. Data Type Finder

You will receive an input until you receive "END". Find what data type is the input. Possible data types are:
•	Integer
•	Floating point
•	Characters
•	Boolean
•	Strings
Print the result in the following format: "{input} is {data type} type"

 */

package L02L08DataTypesAndVariables.Exercise.More.T01DataTypeFinder;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String type = scanner.nextLine();

        while (!type.equals("END")) {
            Scanner input = new Scanner(type);
            if (input.hasNextBoolean()) {
                System.out.printf("%s is boolean type%n", type);
            } else if (input.hasNextInt()) {
                System.out.printf("%s is integer type%n", type);
            } else if (type.length() == 1) {
                System.out.printf("%s is character type%n", type);
            } else if (input.hasNextDouble()) {
                System.out.printf("%s is floating point type%n", type);
            } else if (input.hasNextLine()) {
                System.out.printf("%s is string type%n", type);
            }
            type = scanner.nextLine();
        }
    }
}
