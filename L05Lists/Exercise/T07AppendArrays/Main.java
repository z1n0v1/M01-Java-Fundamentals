/*
    https://judge.softuni.org/Contests/Practice/Index/1297#6

    07. Append Arrays

Write a program to append several arrays of numbers.
	Arrays are separated by "|"
	Values are separated by spaces (" ", one or several)
	Order the arrays from the last to the first, and their values from left to right

 */

package L05Lists.Exercise.T07AppendArrays;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> arrays = Arrays.stream(scanner.nextLine().split("\\|")).collect(Collectors.toList());

        for (int i = arrays.size() - 1; i >= 0 ; i--) {
            List<String> array = Arrays.stream(arrays.get(i).split(" +")).collect(Collectors.toList());
            for (String str : array) {
                if (str.length()>0)
                    System.out.printf("%s ", str);
            }
        }
    }
}
