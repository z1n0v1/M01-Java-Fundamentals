/*
    https://judge.softuni.org/Contests/Practice/Index/1270#5

    06. Balanced Brackets

You will receive n lines. On those lines, you will receive one of the following:
•	Opening bracket – “(“,
•	Closing bracket – “)” or
•	Random string

Your task is to find out if the brackets are balanced. That means after every closing bracket should follow an opening one.
Nested parentheses are not valid, and if two consecutive opening brackets exist, the expression should be marked as unbalanced.

Input
•	On the first line, you will receive n – the number of lines, which will follow
•	On the next n lines, you will receive “(”, “)” or another string

Output
You have to print “BALANCED”, if the parentheses are balanced and “UNBALANCED” otherwise.

Constraints
•	n will be in the interval [1…20]
•	The length of the stings will be between [1…100] characters

 */

package L02L08DataTypesAndVariables.Exercise.More.T06BalancedBrackets;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int balance = 0;
        boolean isNested = false;

        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();

            if(line.contains("(") && line.length() == 1)
                balance++;
            if(line.contains(")") && line.length() == 1)
                balance--;

            if(balance > 1 || balance < 0)
                isNested = true;
        }

        if (balance == 0 && !isNested) {
            System.out.println("BALANCED");
        } else System.out.println("UNBALANCED");

    }
}
