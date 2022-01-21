/*
    https://judge.softuni.org/Contests/Practice/Index/2474#2

    03. Numbers

Write a program to read a sequence of integers and find and print the top 5 numbers that are greater
than the average value in the sequence, sorted in descending order.

Input
Read from the console a single line holding space separated number.

Output
Print the above described numbers on a single line, space separated.
If less than 5 numbers hold the above mentioned property, print less than 5 numbers.
Print “No” if no numbers hold the above property.

Constraints
All input numbers are integers in range [-1 000 000 … 1 000 000]. The count of numbers is in range [1…10 000].
 */

package Exam.E02MidExam.T03Numbers;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

            double average = numbers.stream()
                    .mapToDouble(Double::valueOf).average().getAsDouble();

           numbers = numbers.stream().filter(number -> number > average).collect(Collectors.toList());

           if(numbers.size() == 0)
               System.out.println("No");
           else numbers.stream().sorted(Collections.reverseOrder())
                   .limit(5).forEach(number -> System.out.printf("%d ", number));
    }
}
