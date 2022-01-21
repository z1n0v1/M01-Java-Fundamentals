/*
    https://judge.softuni.org/Contests/Practice/Index/1247#1

    02. Common Elements

Write a program, which prints common elements in two arrays.
You have to compare the elements of the second array to the elements of the first.
 */

package L03Arrays.Exercise.T02CommonElements;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] firstArray = scanner.nextLine().split(" ");
        String[] secondArray = scanner.nextLine().split(" ");

        Arrays.sort(firstArray);
        for (String element : secondArray) {
            if(Arrays.binarySearch(firstArray,element) >= 0)
                System.out.printf("%s ", element);
        }
    }
}
