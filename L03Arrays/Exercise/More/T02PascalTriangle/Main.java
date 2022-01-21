/*
    https://judge.softuni.org/Contests/Practice/Index/1279#1

    02. Pascal Triangle

The triangle may be constructed in the following manner: In row 0 (the topmost row), there is a unique nonzero entry 1.
Each entry of each subsequent row is constructed by adding the number above and to the left with the number above and to the right,
treating blank entries as 0. For example, the initial number in the first (or any other) row is 1 (the sum of 0 and 1),
whereas the numbers 1 and 3 in the third row are added to produce the number 4 in the fourth row.

If you want more info about it: https://en.wikipedia.org/wiki/Pascal's_triangle
Print each row elements separated with whitespace.
 */

package L03Arrays.Exercise.More.T02PascalTriangle;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numRows = Integer.parseInt(scanner.nextLine());

        int[] oddRow = new int[numRows + 2];
        oddRow[1] = 1;
        int[] evenRow = new int[numRows + 2];
        System.out.println(1);
        for (int i = 1; i < numRows; i++) {
            if (i % 2 == 0)
                calculateAndPrint(evenRow, oddRow, numRows);
            else calculateAndPrint(oddRow, evenRow, numRows);
        }
    }

    public static void calculateAndPrint(int[] firstRow, int[] nextRow, int numRows) {
        for (int i = 1; i <= numRows; i++) {
            nextRow[i] = firstRow[i - 1] + firstRow[i];
        }
        for (int num : nextRow)
            if (num != 0)
                System.out.print(num + " ");
        System.out.println();
    }
}
