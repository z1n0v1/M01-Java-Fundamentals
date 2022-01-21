/*
    https://judge.softuni.org/Contests/Practice/Index/1312#1

    02. A Miner Task

Until you receive "stop" command, you will be given a sequence of strings, each on a new line.
Every odd line on the console is representing a resource (e.g. Gold, Silver, Copper, etc.) and every even - quantity.
Your task is to collect the resources and print them each on a new line.

Print the resources and their quantities in format: {resource} –> {quantity}
The quantities inputs will be in the range [1 … 2 000 000 000]
 */

package L08AssociativeArrays.Exercise.T02MinerTask;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, Integer> resources = new LinkedHashMap<>();

        String resource = scanner.nextLine();

        while (!resource.equals("stop")) {
            int quantity = Integer.parseInt(scanner.nextLine());

            if (resources.containsKey(resource)) {
                resources.put(resource,resources.get(resource) + quantity);
            } else {
                resources.put(resource, quantity);
            }

            resource = scanner.nextLine();
        }
        for (Map.Entry<String, Integer> entry : resources.entrySet()) {
            System.out.printf("%s -> %d%n",entry.getKey(), entry.getValue());
        }

    }
}
