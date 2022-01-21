/*
    https://judge.softuni.org/Contests/Practice/Index/1295#0

    01. Sum Adjacent Equal Numbers

Write a program to sum all adjacent equal numbers in a list of decimal numbers, starting from left to right.
	After two numbers are summed, the obtained result could be equal to some of its neighbors and should be summed as well
 (see the examples below).
	Always sum the leftmost two equal neighbors (if several couples of equal neighbors are available).

3 3 6 1	        12 1	    3 3 6 1  6 6 1  12 1
8 2 2 4 8 16    16 8 16	    8 2 2 4 8 16  8 4 4 8 16  8 8 8 16  16 8 16
5 4 2 1 1 4	    5 8 4	    5 4 2 1 1 4  5 4 2 2 4  5 4 4 4  5 8 4
0.1 0.1 5 -5    0.2 5 -5	0.1 0.1 5 -5  0.2 5 -5

 */

package L05Lists.Lab.T01SumAdjacentEqualNumbers;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Double> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Double::parseDouble)
                .collect(Collectors.toList());

        int i = 0;
        while (i < numbers.size() - 1) {
            if (numbers.get(i).equals(numbers.get(i + 1))) {
                numbers.set(i, numbers.get(i) + numbers.get(i + 1));
                numbers.remove(i + 1);
                i = 0;
                continue;
            }
            i++;
        }
        System.out.println(joinElementsByDelimiter(numbers," "));
    }

    private static String joinElementsByDelimiter(List<Double> list, String delimiter) {
        String output = "";

        for (Double element : list) {
            output += (new DecimalFormat("0.#").format(element)) + delimiter;
        }
        return output;
    }
}
