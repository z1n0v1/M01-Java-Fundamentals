/*
    https://judge.softuni.org/Contests/Practice/Index/1247#2

    03. Zig-Zag Arrays

Write a program which creates 2 arrays. You will be given an integer n. On the next n lines, you get 2 integers.
Form 2 arrays as shown below.

In          Out
2           80 19
80 23       23 31
31 19
 */

package L03Arrays.Exercise.T03ZigZagArrays;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        String[] array1 = new String[n];
        String[] array2 = new String[n];
        for (int i = 0; i < n; i++) {
            String[] numbers = scanner.nextLine().split(" ");
            if ((i + 1) % 2 == 1) {
                array1[i] = numbers[0];
                array2[i] = numbers[1];
            } else {
                array1[i] = numbers[1];
                array2[i] = numbers[0];
            }
        }
        System.out.println(String.join(" ", array1));
        System.out.println(String.join(" ", array2));
    }
}
