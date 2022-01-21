/*
    https://judge.softuni.org/Contests/Practice/Index/1674#0

    01. Extract Person Information

Write a program that reads n lines of strings and extracts the name and age of a given person.
The name of the person will be between '@' and '|'.
The person’s age will be between '#' and '*'. Example: "Hello my name is @Peter| and I am #20* years old."
For each found name and age print a line in the following format "{name} is {age} years old."
 */

package L09TextProcessing.Exercise.More.T01ExtractPersonInformation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            StringBuilder name = new StringBuilder(), age = new StringBuilder();
            boolean inName = false, inAge = false;
            for (int j = 0; j < input.length(); j++) {

                if (input.charAt(j) == '@') inName = true;
                else if (input.charAt(j) == '|') inName = false;
                else if (input.charAt(j) == '#') inAge = true;
                else if (input.charAt(j) == '*') inAge = false;
                else if (inName) name.append(input.charAt(j));
                else if (inAge) age.append(input.charAt(j));
            }
            System.out.printf("%s is %s years old.%n", name, age);
        }
    }
}
