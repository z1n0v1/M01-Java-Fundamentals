/*
    https://judge.softuni.org/Contests/Practice/Index/1308#1

    02. Car Race

Write a program to calculate the winner of a car race. You will receive an array of numbers.
Each element of the array represents the time needed to pass through that step (the index).
There are going to be two cars. One of them starts from the left side and the other one starts from the right side.
The middle index of the array is the finish line. (The number of elements of the array will always be odd).
Calculate the total time for each racer to reach the finish (the middle of the array) and print the winner with his total time.
(The racer with less time). If you have a zero in the array,
you have to reduce the time of the racer that reached it by 20% (from the time so far).

Print the result in the following format "The winner is {left/right} with total time: {total time}",
formatted with one digit after the decimal point.
 */

package L05Lists.Exercise.More.T02CarRace;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double[] track = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToDouble(Double::parseDouble).toArray();
        double leftTime = 0, rightTime = 0;
        int finishLine = track.length/2;

        for (int i = 0; i < finishLine; i++) {
            if(track[i] == 0)
                leftTime *= 0.8;
            else leftTime += track[i];
        }
        for (int i = track.length - 1; i > finishLine ; i--) {
            if(track[i] == 0)
                rightTime *= 0.8;
            else rightTime += track[i];
        }
        if(leftTime > rightTime)
            System.out.printf("The winner is right with total time: %.1f",rightTime);
        else System.out.printf("The winner is left with total time: %.1f",leftTime);
    }
}
