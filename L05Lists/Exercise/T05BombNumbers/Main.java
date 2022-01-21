/*
    https://judge.softuni.org/Contests/Practice/Index/1297#4

    05. Bomb Numbers

Write a program that reads sequence of numbers and special bomb number with a certain power.
Your task is to detonate every occurrence of the special bomb number and according to its power - his neighbors from left and right.
Detonations are performed from left to right and all detonated numbers disappear.
Finally print the sum of the remaining elements in the sequence.
 */

package L05Lists.Exercise.T05BombNumbers;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    static List<Integer> numbers;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        int[] powerInfo = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int bombNumber = powerInfo[0];
        int power = powerInfo[1];

        while (numbers.contains(bombNumber)) {
            detonate(numbers.indexOf(bombNumber), power);
        }

        int sum = 0;
        for (Integer number : numbers)
            sum+=number;
        System.out.println(sum);

    }
    private static void detonate(int bombIndex, int power) {
        int left = Math.max(0, bombIndex - power);
        int right = Math.min(numbers.size() - 1, bombIndex + power);

        for (int i = right; i >=left ; i--) {
            numbers.remove(i);
        }
    }
}
