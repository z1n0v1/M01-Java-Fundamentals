/*
    https://judge.softuni.org/Contests/Practice/Index/1248#2

    03. Sum Even Numbers

Read an array from the console and sum only the even numbers.
 */

package L03Arrays.Lab.T03SumEvenNumbers;

import java.util.Scanner;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(
                Stream.of(scanner.nextLine().split(" "))
                        .mapToInt( e -> Integer.parseInt(e))
                        .filter(e -> e % 2 == 0)
                        .sum()
        );

    }
}
