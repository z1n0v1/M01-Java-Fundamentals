/*
    https://judge.softuni.org/Contests/Practice/Index/1311#3

    04. Word Filter

Read an array of strings, take only words which length is even. Print each word on a new line.
 */

package L08AssociativeArrays.Lab.T04WordFilter;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] words = Arrays.stream(scanner.nextLine().split("\\s+"))
                .filter(e -> e.length() % 2 == 0).toArray(String[]::new);
        for (String word : words)
            System.out.println(word);

    }


}
