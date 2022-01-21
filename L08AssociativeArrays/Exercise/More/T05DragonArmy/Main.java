/*
    https://judge.softuni.org/Contests/Practice/Index/1313#4

    05. Dragon Army

Heroes III is the best game ever. Everyone loves it and everyone plays it all the time.
Stamat is no exclusion to this rule. His favorite units in the game are all types of dragons - black, red, gold, azure etc…
He likes them so much that he gives them names and keeps logs of their stats: damage, health and armor.
The process of aggregating all the data is quite tedious, so he would like to have a program doing it.
Since he is no programmer, it's your task to help him.
You need to categorize dragons by their type. For each dragon, identified by name, keep information about his stats.
Type is preserved as in the order of input, but dragons are sorted alphabetically by name. For each type,
you should also print the average damage, health and armor of the dragons. For each dragon, print his own stats.
There may be missing stats in the input, though. If a stat is missing, you should assign it default values.
Default values are as follows: health 250, damage 45 and armor 10. Missing stat will be marked by null.
The input is in the following format {type} {name} {damage} {health} {armor}.
Any of the integers may be assigned null value. See the examples below for better understanding of your task.
If the same dragon is added a second time, the new stats should overwrite the previous ones.
Two dragons are considered equal if they match by both name and type.

Input
•	On the first line you are given number N - the number of dragons to follow
•	On the next N lines you are given input in the format described above. There will be single space separating each element

Output
•	Print the aggregated data on the console
•	For each type print average stats of its dragons in format "{Type}::({damage}/{health}/{armor})"
•	Damage, health and armor should be rounded to two digits after the decimal separator
•	For each dragon print its stats in format:
"-{Name} -> damage: {damage}, health: {health}, armor: {armor}"

Constraints
•	N is in range [1…100]
•	The dragon type and name are one word only, starting with capital letter
•	Damage, health and armor are integers in range [0 … 100000] or null

 */

package L08AssociativeArrays.Exercise.More.T05DragonArmy;

import java.util.*;

public class Main {
    private static LinkedHashMap<String, List<Dragon>> types;

    private static class Dragon {
        private String name, type;
        private int damage, health, armor;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public Dragon(String name, String type, int damage, int health, int armor) {
            this.name = name;
            this.type = type;
            this.damage = damage;
            this.health = health;
            this.armor = armor;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getDamage() {
            return damage;
        }

        public void setDamage(int damage) {
            this.damage = damage;
        }

        public int getHealth() {
            return health;
        }

        public void setHealth(int health) {
            this.health = health;
        }

        public int getArmor() {
            return armor;
        }

        public void setArmor(int armor) {
            this.armor = armor;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        types = new LinkedHashMap<>();

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] data = scanner.nextLine().split("\\s+");
            String type = data[0], name = data[1];
            int damage = 45, health = 250, armor = 10;

            if(!data[2].equals("null")) damage = Integer.parseInt(data[2]);
            if(!data[3].equals("null")) health = Integer.parseInt(data[3]);
            if(!data[4].equals("null")) armor = Integer.parseInt(data[4]);

            if (!types.containsKey(type)) {
                List<Dragon> dragons = new ArrayList<>();
                Dragon dragon = new Dragon(name, type, damage, health, armor);
                dragons.add(dragon);
                types.put(type, dragons);
            }
            Dragon dragon = findDragon(type, name);

            if (dragon == null) {
                dragon = new Dragon(name, type, damage, health, armor);
                types.get(type).add(dragon);
            } else {
                dragon.setArmor(armor);
                dragon.setDamage(damage);
                dragon.setHealth(health);
            }
        }

        for (Map.Entry<String,List<Dragon>> type : types.entrySet()) {
            String typeName = type.getKey();
            List<Dragon> dragons = type.getValue();
            double averageArmor = averageArmor(typeName),
                    averageHealth = averageHealth(typeName),
                    averageDamage = averageDamage(typeName);
            System.out.printf("%s::(%.2f/%.2f/%.2f)%n",typeName,averageDamage, averageHealth, averageArmor);
            dragons.stream().sorted(Comparator.comparing(Dragon::getName))
                    .forEach(dragon -> System.out.printf("-%s -> damage: %d, health: %d, armor: %d%n",
                            dragon.getName(), dragon.getDamage(), dragon.getHealth(), dragon.getArmor()));
        }
    }

    private static double averageArmor(String type) {
        double armorSum = 0;
        List<Dragon> dragons = types.get(type);
        for (Dragon dragon : dragons) {
            armorSum += dragon.getArmor();
        }
        return armorSum / dragons.size();
    }

    private static double averageHealth(String type) {
        double healthSum = 0;
        List<Dragon> dragons = types.get(type);
        for (Dragon dragon : dragons) {
            healthSum += dragon.getHealth();
        }
        return healthSum / dragons.size();
    }

    private static double averageDamage(String type) {
        double damageSum = 0;
        List<Dragon> dragons = types.get(type);

        for (Dragon dragon : dragons) {
            damageSum += dragon.getDamage();
        }
        return damageSum / dragons.size();
    }

    private static Dragon findDragon(String type, String name) {
        List<Dragon> dragons = types.get(type);
        if (dragons == null) return null;
        for (Dragon dragon : dragons) {
            if (dragon.getType().equals(type) && dragon.getName().equals(name)) {
                return dragon;
            }
        }
        return null;

    }
}
