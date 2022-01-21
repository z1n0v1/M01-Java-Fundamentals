/*
    https://judge.softuni.org/Contests/Practice/Index/1295#6

    07. Remove Negatives and Reverse

Read a list of integers, remove all negative numbers from it and print the remaining elements in reversed order.
In case of no elements left in the list, print "empty".
 */

package L05Lists.Lab.T07RemoveNegativesAndReverse;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        numbers.removeIf( e -> e < 0);

        if (numbers.size() == 0) {
            System.out.println("empty");
        } else {
            Collections.reverse(numbers);
            for (Integer num : numbers)
                System.out.printf("%d ", num);
        }
    }
}
