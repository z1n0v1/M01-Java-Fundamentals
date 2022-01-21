/*
    https://judge.softuni.org/Contests/Practice/Index/1190#5

    06. Foreign Languages

Write a program, which prints the language, that a given country speaks.
You can receive only the following combinations:
English is spoken in England and USA; Spanish is spoken in Spain, Argentina and Mexico;
for the others, we should print "unknown".

Input
You will receive a single country name on a single line.

Output
Print the language, which the country speaks, or if it is unknown for your program, print "unknown".

 */
package L01BasicSyntaxConditionalStatementsAndLoops.Lab.T06ForeignLanguages;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String country = scanner.nextLine();
        String language;
        switch (country) {
            case "England":
            case "USA":
                language = "English";
                break;
            case "Spain":
            case "Argentina":
            case "Mexico":
                language = "Spanish";
                break;
            default: language = "unknown";
        }
        System.out.println(language);
    }
}
