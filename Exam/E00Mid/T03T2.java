package Exam.E00Mid;

import java.util.Arrays;
import java.util.Scanner;

public class T03T2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] items = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        int entryPoint = Integer.parseInt(scanner.nextLine());
        String type = scanner.nextLine();

        int entryPointPrice = items[entryPoint];
        boolean isCheap = false;
        if (type.equals("cheap"))
            isCheap = true;

        int sumLeft = calcSumLeft(items, entryPoint, isCheap);
        int sumRight = calcSumRight(items, entryPoint, isCheap);

        if( sumLeft >= sumRight) {
            System.out.printf("Left - %d", sumLeft);
        } else {
            System.out.printf("Right - %d", sumRight);
        }
    }

    private static int calcSumLeft(int[] items, int entryPoint, boolean isCheap) {
        int sum = 0;
        int price = items[entryPoint];
        for (int i = 0; i < entryPoint; i++) {
            if(isCheap) {
                if (items[i] < price)
                    sum += items[i];
            } else {
                if (items[i] >= price)
                    sum += items[i];
            }
        }
        return sum;
    }

    private static int calcSumRight(int[] items, int entryPoint, boolean isCheap) {
        int sum = 0;
        int price = items[entryPoint];
        for (int i = entryPoint + 1; i < items.length; i++) {
            if(isCheap) {
                if (items[i] < price)
                    sum += items[i];
            } else {
                if (items[i] >= price)
                    sum += items[i];
            }
        }
        return sum;
    }
}
