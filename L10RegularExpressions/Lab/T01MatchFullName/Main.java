/*
    https://judge.softuni.org/Contests/Practice/Index/1672#0

    01. Match Full Name

Write a Java Program to match full names from a list of names and print them on the console.
 */

package L10RegularExpressions.Lab.T01MatchFullName;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String regex = "\\b[A-Z][a-z]+ [A-Z][a-z]+\\b";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            System.out.print(matcher.group() + " ");
        }
    }
}
