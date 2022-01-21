package Exam.E06Mid;

import java.util.Scanner;

public class T01BlackFlag {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int plunderDays = Integer.parseInt(scanner.nextLine());
        double dailyPlunder = Double.parseDouble(scanner.nextLine());
        double expectedPlunder = Double.parseDouble(scanner.nextLine());

        double currentPlunder = 0;
        for (int day = 1; day <= plunderDays; day++) {
            if (day % 3 == 0) {
                currentPlunder += dailyPlunder * 1.5;
            } else currentPlunder += dailyPlunder;

            if (day % 5 == 0) {
                currentPlunder *= 0.7;
            }
        }
        if (currentPlunder >= expectedPlunder) {
            System.out.printf("Ahoy! %.2f plunder gained.%n", currentPlunder);
        } else {
            System.out.printf("Collected only %.2f%% of the plunder.%n",
                    currentPlunder/expectedPlunder*100);
        }
    }
}
