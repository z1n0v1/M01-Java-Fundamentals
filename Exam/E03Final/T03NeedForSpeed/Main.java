package Exam.E03Final.T03NeedForSpeed;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashMap<String, Integer> carMileage = new LinkedHashMap<>();
        LinkedHashMap<String, Integer> carTank = new LinkedHashMap<>();

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] data = scanner.nextLine().split("\\|");
            carMileage.put(data[0], Integer.parseInt(data[1]));
            carTank.put(data[0], Integer.parseInt(data[2]));
        }

        String input = scanner.nextLine();
        while (!input.equals("Stop")) {
            String[] command = input.split(" \\: ");

            switch (command[0]) {
                case "Drive": {
                    String car = command[1];
                    int distance = Integer.parseInt(command[2]);
                    int fuel = Integer.parseInt(command[3]);

                    int mileage = carMileage.get(car);
                    int tank = carTank.get(car);

                    if (tank - fuel < 0) {
                        System.out.println("Not enough fuel to make that ride");
                    } else {
                        carTank.put(car, tank - fuel);
                        carMileage.put(car, mileage + distance);
                        System.out.printf("%s driven for %d kilometers. %d liters of fuel consumed.%n",
                                car, distance, fuel);
                    }
                    if (mileage + distance >= 100000) {
                        System.out.printf("Time to sell the %s!%n", car);
                        carMileage.remove(car);
                        carTank.remove(car);
                    }
                    break;
                }
                case "Refuel": {
                    String car = command[1];
                    int fuel = Integer.parseInt(command[2]);
                    int tank = carTank.get(car);

                    if (tank + fuel > 75)
                        fuel = 75 - tank;

                    System.out.printf("%s refueled with %d liters%n", car, fuel);
                    carTank.put(car, tank + fuel);
                    break;
                }
                case "Revert": {
                    String car = command[1];
                    int km = Integer.parseInt(command[2]);
                    int mileage = carMileage.get(car);
                    mileage -= km;
                    if (mileage < 10000)
                        mileage = 10000;
                    else System.out.printf("%s mileage decreased by %d kilometers%n", car, km);
                    carMileage.put(car, mileage);
                    break;
                }
            }
            input = scanner.nextLine();
        }

        carMileage.entrySet().stream().sorted((a,b) -> {
            if (a.getValue().equals(b.getValue())) {
                return a.getKey().compareTo(b.getKey());
            }
            return  b.getValue().compareTo(a.getValue());
        }).forEach(e -> {
            String name = e.getKey();
            int mileage = e.getValue();
            int tank = carTank.get(name);
            System.out.printf("%s -> Mileage: %d kms, Fuel in the tank: %d lt.%n", name, mileage, tank);
        });
    }
}
