/*
    https://judge.softuni.org/Contests/Practice/Index/2525#1

    02. Ad Astra

You are an astronaut who just embarked on a mission across the solar system.
Since you will be in space for a long time, you have packed a lot of food with you. Create a program, which helps you
identify how much food you have left and gives you information about its expiration date.
On the first line of the input you will be given a text string.
You must extract the information about the food and calculate the total calories.
First you must extract the food info. It will always follow the same pattern rules:
•	It will be surrounded by "|" or "#" (only one of the two) in the following pattern:
#{item name}#{expiration date}#{calories}#   or
|{item name}|{expiration date}|{calories}|
•	The item name will contain only lowercase and uppercase letters and whitespace
•	The expiration date will always follow the pattern: {day}/{month}/{year}, where the day,
month and year will be exactly two digits long
•	The calories will be an integer between 0-10000
Calculate the total calories of all food items and then determine how many days you can last with the food you have.
Keep in mind that you need 2000kcal a day.
Input / Constraints
•	You will receive a single string
Output
•	First print the amount of days you will be able to last with the food you have:
"You have food to last you for: {days} days!"
•	The output for each food item should look like this:
"Item: {item name}, Best before: {expiration date}, Nutrition: {calories}"

 */

package Exam.E01Final.T02AdAstra;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    static class Food {
        String name;
        int day, month, year, nutrition;

        public Food(String name, int day, int month, int year, int nutrition) {
            this.name = name;
            this.day = day;
            this.month = month;
            this.year = year;
            this.nutrition = nutrition;
        }
        public String toString() {
            return String.format("Item: %s, Best before: %02d/%02d/%2d, Nutrition: %d",
                    name, day, month, year, nutrition);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Matcher foodMatcher = Pattern.compile(
                "([\\|#])(?<item>[a-zA-Z ]+)\\1(?<day>\\d{2})\\/(?<month>\\d{2})\\/(?<year>\\d{2})\\1(?<nutrition>\\d+)\\1"
        ).matcher(input);
        List<Food> items = new ArrayList<>();
        int calories = 0;

        while (foodMatcher.find()) {
            String name = foodMatcher.group("item");
            int day = Integer.parseInt(foodMatcher.group("day"));
            int month = Integer.parseInt(foodMatcher.group("month"));
            int year = Integer.parseInt(foodMatcher.group("year"));
            int nutrition = Integer.parseInt(foodMatcher.group("nutrition"));
            Food item = new Food(name, day, month, year, nutrition);
            items.add(item);
            calories+=nutrition;
        }
        System.out.printf("You have food to last you for: %d days!%n", calories / 2000);
        for (Food item : items)
            System.out.println(item);

    }
}
