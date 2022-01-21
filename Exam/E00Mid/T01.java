package Exam.E00Mid;

import java.util.Scanner;

public class T01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numCities = Integer.parseInt(scanner.nextLine());
        double totalProfit = 0;

        for (int city = 1; city <= numCities; city++) {
            String name = scanner.nextLine();
            double moneyEarned = Double.parseDouble(scanner.nextLine());
            double expenses = Double.parseDouble(scanner.nextLine());

            if(city % 5 == 0) {
                moneyEarned *= 0.9;
            } else if (city % 3 == 0) {
                expenses *= 1.5;
            }
            double profit = moneyEarned - expenses;
            System.out.printf("In %s Burger Bus earned %.2f leva.%n", name, profit);
            totalProfit += profit;
        }
        System.out.printf("Burger Bus total profit: %.2f leva.", totalProfit);
    }
}
