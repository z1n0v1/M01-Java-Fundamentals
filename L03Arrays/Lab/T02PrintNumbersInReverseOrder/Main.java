/*
    https://judge.softuni.org/Contests/Practice/Index/1248#1
    02. Print Numbers in Reverse Order

Read n numbers and print them in reverse order.
 */

package L03Arrays.Lab.T02PrintNumbersInReverseOrder;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int[] numbers = new int[n];

        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(scanner.nextLine());
        }

        for (int i = n - 1; i >= 0; i--) {
            System.out.printf("%d ", numbers[i]);
        }
    }
}
