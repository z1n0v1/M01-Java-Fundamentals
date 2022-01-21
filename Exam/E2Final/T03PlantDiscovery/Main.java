/*

    https://judge.softuni.org/Contests/Practice/Index/2518#2

    03. Plant Discovery

You have now returned from your world tour. On your way you have discovered some new plants
and you want to gather some information about them and create an exhibition to see which plant is highest rated.
On the first line you will receive a number n. On the next n lines, you will be given some information about the plants
that you have discovered in the format: "{plant}<->{rarity}". Store that information, because you will need it later.
If you receive a plant more than once, update its rarity.
After that until you receive the command "Exhibition" you will be given some of these commands:
•	Rate: {plant} - {rating} – add the given rating to the plant (store all ratings)
•	Update: {plant} - {new_rarity} – update the rarity of the plant with the new one
•	Reset: {plant} – remove all the ratings of the given plant
Note: If any of the command is invalid, print "error"
After the command "Exhibition" print the information that you have about the plants in the following format:
Plants for the exhibition:
- {plant_name}; Rarity: {rarity}; Rating: {average_rating formatted to the 2nd digit}
…
The plants should be sorted by rarity descending, then by average rating descending
Input / Constraints
•	You will recive the input as described above
•	JavaScript: you will receive a list of strings
Output
•	Print the information about all plants as described above
 */

package Exam.E2Final.T03PlantDiscovery;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;

public class Main {

    static class Plant {
        String name;
        int rarity;
        double sumRatings;
        int numRatings;

        public void setRarity(int rarity) {
            this.rarity = rarity;
        }

        public Plant(String name, int rarity) {
            this.name = name;
            this.rarity = rarity;
            sumRatings = 0;
            numRatings = 0;
        }

        public int getRarity() {
            return rarity;
        }

        public void addRating(int rating) {
            sumRatings += rating;
            numRatings++;
        }
        public void resetRatings() {
            sumRatings = 0;
            numRatings = 0;
        }
        public double getAverageRating() {
            if(numRatings == 0)
                return 0;
            return sumRatings/numRatings;
        }
        public String toString() {
            return String.format(" - %s; Rarity: %d; Rating: %.2f", name, rarity, getAverageRating());
        }
    }

    static LinkedHashMap<String, Plant> plants;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        plants = new LinkedHashMap<>();

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] data = scanner.nextLine().split("<->");
            int rarity = Integer.parseInt(data[1]);
            if (!plants.containsKey(data[0]))
                plants.put(data[0], new Plant(data[0], rarity));
            else plants.get(data[0]).setRarity(rarity);
        }

        String input = scanner.nextLine();

        while (!input.equals("Exhibition")) {
            String[] data = input.split("\\s*[\\:\\-]\\s*");
            String plantName = data[1];
            if(!plants.containsKey(plantName)) {
                System.out.println("error");
                input = scanner.nextLine();
                continue;
            }
            switch (data[0]) {
                case "Rate": {
                    int rating = Integer.parseInt(data[2]);
                    plants.get(plantName).addRating(rating);
                    break;
                }
                case "Update": {
                    int newRarity = Integer.parseInt(data[2]);
                    plants.get(plantName).setRarity(newRarity);
                    break;
                }
                case "Reset": {
                    plants.get(plantName).resetRatings();
                    break;
                }
            }
            input = scanner.nextLine();
        }

        System.out.println("Plants for the exhibition:");
        plants.values().stream().sorted((a,b) -> {
            if(a.getRarity() == b.getRarity()) {
                return (int) Math.ceil(b.getAverageRating() - a.getAverageRating());
            }
            return b.getRarity() - a.getRarity();
        }).forEach(System.out::println);

    }
}
