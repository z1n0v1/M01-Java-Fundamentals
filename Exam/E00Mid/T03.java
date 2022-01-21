package Exam.E00Mid;

import java.util.Arrays;
import java.util.Scanner;

public class T03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] items = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        int entrypoint = Integer.parseInt(scanner.nextLine());
        String type = scanner.nextLine();
        int entryPrice = items[entrypoint];
        boolean isLeft = false;
        int sum = 0;
        if (type.equals("cheap")) {
            if (items[entrypoint - 1] <= items[entrypoint + 1]) {
                // left
                System.out.printf("Left %d%n", calcLeft(items, entrypoint));
            } else {
                System.out.printf("Right %d%n", calcRight(items, entrypoint));
            }
        } else {
            if (items[entrypoint - 1] >= items[entrypoint + 1]) {
                // left
                System.out.printf("Left %d%n", calcLeft(items, entrypoint));
            } else {
                System.out.printf("Right %d%n", calcRight(items, entrypoint));
            }
        }
    }

    private static int calcLeft(int[] items, int startingIndex) {
        int sum = 0;
        int entryPrice = items[startingIndex];
        for (int i = 0; i < startingIndex; i++) {
            if (items[i] > entryPrice)
                sum += items[i];
        }
        return sum;
    }

    private static int calcRight(int[] items, int startingIndex) {
        int sum = 0;
        int entryPrice = items[startingIndex];
        for (int i = startingIndex + 1; i < items.length; i++) {
            if (items[i] > entryPrice)
                sum += items[i];
        }
        return sum;
    }

}
