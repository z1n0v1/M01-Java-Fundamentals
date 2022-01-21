package Exam.E06Mid;

import java.util.Arrays;
import java.util.Scanner;

public class T03ManOWar {
    static int[] pirateShip;
    static int[] warship;
    static int maxHealth;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        pirateShip = Arrays.stream(scanner.nextLine().split(">")).mapToInt(Integer::parseInt).toArray();
        warship = Arrays.stream(scanner.nextLine().split(">")).mapToInt(Integer::parseInt).toArray();
        maxHealth = Integer.parseInt(scanner.nextLine());

        String input = scanner.nextLine();

        while (!input.equals("Retire")) {
            String data[] = input.split("\\s+");

            switch (data[0]) {
                case "Fire": {
                    int index = Integer.parseInt(data[1]);
                    int damage = Integer.parseInt(data[2]);

                    if (fire(index, damage)) {
                        // warship sunk
                        System.out.println("You won! The enemy ship has sunken.");
                        return;
                    }
                    break;
                }
                case "Defend": {
                    int startIndex = Integer.parseInt(data[1]);
                    int endIndex = Integer.parseInt(data[2]);
                    int damage = Integer.parseInt(data[3]);
                    if (defend(startIndex, endIndex, damage)) {
                        System.out.println("You lost! The pirate ship has sunken.");
                        return;
                    }
                    break;
                }
                case "Repair": {
                    int index = Integer.parseInt(data[1]);
                    int health = Integer.parseInt(data[2]);
                    repair(index, health);
                    break;
                }
                case "Status": {
                    System.out.printf("%d sections need repair.%n", status());
                    break;
                }
            }
//            System.out.println(Arrays.toString(pirateShip));
//            System.out.println(Arrays.toString(warship));
            input = scanner.nextLine();
        }
        System.out.printf("Pirate ship status: %d%n", pirateShipSum());
        System.out.printf("Warship status: %d%n", warshipSum());
    }

    private static int warshipSum() {
        int sum = 0;
        for (int section : warship)
            sum += section;
        return sum;
    }

    private static int pirateShipSum() {
        int sum = 0;
        for (int section : pirateShip)
            sum += section;
        return sum;
    }

    private static int status() {
        int sections = 0;
        for (int section : pirateShip)
            if (section < 0.2 * maxHealth)
                sections++;
        return sections;
    }

    private static void repair(int index, int health) {
        if (index >= 0 && index < pirateShip.length) {
            pirateShip[index] += health;
            if (pirateShip[index] > maxHealth)
                pirateShip[index] = maxHealth;
        }
    }

    private static boolean defend(int startIndex, int endIndex, int damage) {
        if (startIndex <= endIndex && startIndex >= 0 && endIndex < pirateShip.length) {
            for (int index = startIndex; index <= endIndex; index++) {
                pirateShip[index] -= damage;
                if (pirateShip[index] <= 0)
                    return true;
            }
        }

        return false;
    }

    private static boolean fire(int index, int damage) {
        if (index >= 0 && index < warship.length) {
            warship[index] -= damage;
            if (warship[index] <= 0)
                return true;
        }

        return false;
    }
}
