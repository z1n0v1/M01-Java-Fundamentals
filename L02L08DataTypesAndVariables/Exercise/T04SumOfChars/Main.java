/*
    https://judge.softuni.org/Contests/Practice/Index/1228#3

    04. Sum of Chars

Write a program, which sums the ASCII codes of n characters.
Print the sum on the console.
Input
•	On the first line, you will receive n – the number of lines, which will follow
•	On the next n lines – you will receive letters from the Latin alphabet
Output
Print the total sum in the following format:
The sum equals: {totalSum}
Constraints
•	n will be in the interval [1…20].
•	The characters will always be either upper or lower-case letters from the English alphabet
•	You will always receive one letter per line

 */

package L02L08DataTypesAndVariables.Exercise.T04SumOfChars;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numCharacters = Integer.parseInt(scanner.nextLine());
        int sum = 0;
        for (int i = 0; i < numCharacters; i++) {
            sum += scanner.nextLine().charAt(0);
        }
        System.out.printf("The sum equals: %d%n", sum);
    }
}
