/*
    https://judge.softuni.org/Contests/Practice/Index/1228#10

    11.Snowballs

Tony and Andi love playing in the snow and having snowball fights, but they always argue which makes the best snowballs.
 Тhey have decided to involve you in their fray, by making you write a program which calculates snowball data,
 and outputs the best snowball value.

You will receive N – an integer, the number of snowballs being made by Tony and Andi.

For each snowball you will receive 3 input lines:
•	On the first line you will get the snowballSnow – an integer.
•	On the second line you will get the snowballTime – an integer.
•	On the third line you will get the snowballQuality – an integer.

For each snowball you must calculate its snowballValue by the following formula:
(snowballSnow / snowballTime) ^ snowballQuality

At the end you must print the highest calculated snowballValue.

Input
•	On the first input line you will receive N – the number of snowballs.
•	On the next N * 3 input lines you will be receiving data about snowballs.

Output
•	As output you must print the highest calculated snowballValue, by the formula, specified above.
•	The output format is:
{snowballSnow} : {snowballTime} = {snowballValue} ({snowballQuality})

Constraints
•	The number of snowballs (N) will be an integer in range [0, 100].
•	The snowballSnow is an integer in range [0, 1000].
•	The snowballTime is an integer in range [1, 500].
•	The snowballQuality is an integer in range [0, 100].
•	Allowed working time / memory: 100ms / 16MB.

 */

package L02L08DataTypesAndVariables.Exercise.T11Snowballs;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int bestSnowballSnow = 0, bestSnowballTime = 0, bestSnowballQuality = 0;
        double bestSnowballValue = 0;

        for (int snowball = 0; snowball < n; snowball++) {
            int snowballSnow = Integer.parseInt(scanner.nextLine());
            int snowballTime = Integer.parseInt(scanner.nextLine());
            int snowballQuality = Integer.parseInt(scanner.nextLine());

            double snowballValue = Math.pow(snowballSnow * 1.0 / snowballTime, snowballQuality);

            if (snowballValue > bestSnowballValue) {
                bestSnowballSnow = snowballSnow;
                bestSnowballQuality = snowballQuality;
                bestSnowballTime = snowballTime;
                bestSnowballValue = snowballValue;
            }
        }
        System.out.printf("%d : %d = %.0f (%d)",bestSnowballSnow,bestSnowballTime,bestSnowballValue,bestSnowballQuality);
    }
}
