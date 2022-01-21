/*
    https://judge.softuni.org/Contests/Practice/Index/1311#4

    05. Largest 3 Numbers

Read a list of integers and print largest 3 of them. If there are less than 3, print all of them.
 */

package L08AssociativeArrays.Lab.T05Largest3Numbers;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Arrays.stream(scanner.nextLine().split("\\s"))
                .map(Integer::parseInt).sorted(Comparator.reverseOrder()).limit(3)
                .forEach(value -> System.out.printf("%s ", value));
    }
}
