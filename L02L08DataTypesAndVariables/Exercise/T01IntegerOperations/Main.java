/*
    https://judge.softuni.org/Contests/Practice/Index/1228#0

    01. Integer Operations

Read four integer numbers.
Add first to the second, divide (integer) the sum by the third number and multiply the result by the fourth number. Print the result.
Constraints
•	First number will be in the range [-2,147,483,648… 2,147,483,647]
•	Second number will be in the range [-2,147,483,648… 2,147,483,647]
•	Third number will be in the range [-2,147,483,648… 2,147,483,647]
•	Fourth number will be in the range [-2,147,483,648… 2,147,483,647]

 */

package L02L08DataTypesAndVariables.Exercise.T01IntegerOperations;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstNumber = Integer.parseInt(scanner.nextLine());
        int secondNumber = Integer.parseInt(scanner.nextLine());
        int thirdNumber = Integer.parseInt(scanner.nextLine());
        int forthNumber = Integer.parseInt(scanner.nextLine());

        int result = firstNumber + secondNumber;
        result /= thirdNumber;
        result *= forthNumber;
        System.out.println(result);
    }
}
