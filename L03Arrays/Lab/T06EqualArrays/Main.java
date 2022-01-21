/*
    https://judge.softuni.org/Contests/Practice/Index/1248#5

    06. Equal Arrays

Read two arrays and print on the console whether they are identical or not. Arrays are identical if their elements are equal.
If the arrays are identical find the sum of the first one and print on the console following message:
"Arrays are identical. Sum: {sum}", otherwise find the first index where the arrays differ
and print on the console following message: "Arrays are not identical. Found difference at {index} index."
 */

package L03Arrays.Lab.T06EqualArrays;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] firstArray = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] secondArray = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int sum = 0, notEqualIndex = -1;
        if (firstArray.length != secondArray.length) {
            notEqualIndex = Math.min(firstArray.length , secondArray.length );
        } else {
            for (int i = 0; i < firstArray.length; i++) {
                if (firstArray[i] == secondArray[i])
                    sum += firstArray[i];
                else {
                    notEqualIndex = i;
                    break;
                }
            }
        }
        if (notEqualIndex == -1)
            System.out.printf("Arrays are identical. Sum: %d", sum);
        else System.out.printf("Arrays are not identical. Found difference at %d index.",notEqualIndex);

    }
}
