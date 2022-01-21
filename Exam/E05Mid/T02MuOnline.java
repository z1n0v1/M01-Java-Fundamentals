package Exam.E05Mid;

import java.util.Arrays;
import java.util.Scanner;

public class T02MuOnline {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] rooms = scanner.nextLine().split("\\|");

        int health = 100, bitcoins = 0, bestRoom = 0;
        String slainBy = "";
        boolean isDead = false;
        for (String room : rooms) {
            String[] data = room.split("\\s+");
            bestRoom++;
            switch (data[0]) {
                case "potion": {
                    int potion = Integer.parseInt(data[1]);
                    if (health + potion > 100) {
                        potion = 100 - health;
                    }
                    health += potion;
                    System.out.printf("You healed for %d hp.%n", potion);
                    System.out.printf("Current health: %d hp.%n", health);
                    break;
                }
                case "chest": {
                    int addBitcoin = Integer.parseInt(data[1]);
                    bitcoins += addBitcoin;
                    System.out.printf("You found %d bitcoins.%n", addBitcoin);
                    break;
                }
                default: {
                    int monsterHp = Integer.parseInt(data[1]);
                    if (health - monsterHp <= 0) {
                        slainBy = data[0];
                        isDead = true;
                        break;
                    }
                    health -= monsterHp;
                    System.out.printf("You slayed %s.%n", data[0]);
                }
            }
            if(isDead) break;
        }

        if(isDead) {
            System.out.printf("You died! Killed by %s.%n", slainBy);
            System.out.printf("Best room: %d", bestRoom);
        } else {
            System.out.println("You've made it!");
            System.out.printf("Bitcoins: %d%n", bitcoins);
            System.out.printf("Health: %d", health);
        }
    }
}
