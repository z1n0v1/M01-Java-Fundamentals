/*
    https://judge.softuni.org/Contests/Practice/Index/1672#2

    03. Match Dates

Write a program, which matches a date in the format “dd{separator}MMM{separator}yyyy”.
Use named capturing groups in your regular expression.

Compose the Regular Expression
Every valid date has the following characteristics:
•	Always starts with two digits, followed by a separator
•	After that, it has one uppercase and two lowercase letters (e.g. Jan, Mar).
•	After that, it has a separator and exactly 4 digits (for the year).
•	The separator could be either of three things: a period (“.”), a hyphen (“-“) or a forward slash (“/”)
•	The separator needs to be the same for the whole date (e.g. 13.03.2016 is valid, 13.03/2016 is NOT).
Use a group backreference to check for this.

 */

package L10RegularExpressions.Lab.T03MatchDates;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String regex ="\\b(?<day>\\d{2})([\\/\\.\\-])(?<month>[A-Z][a-z]{2})\\2(?<year>\\d{4})\\b";
        String dates = scanner.nextLine();

        Pattern datePattern = Pattern.compile(regex);
        Matcher dateMatcher = datePattern.matcher(dates);

        while (dateMatcher.find()) {
            String day = dateMatcher.group("day");
            String month = dateMatcher.group("month");
            String year = dateMatcher.group("year");

            System.out.printf("Day: %s, Month: %s, Year: %s%n", day, month, year);
        }
    }
}
