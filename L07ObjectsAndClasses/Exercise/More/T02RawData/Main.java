/*
    https://judge.softuni.org/Contests/Practice/Index/1328#1

    02. Raw Data

You are the owner of a courier company and want to make a system for tracking your cars and their cargo.
Define a class Car that holds information about model, engine, cargo and a collection of exactly 4 tires.
The engine, cargo and tire should be separate classes, create a constructor that receives all information about the
Car and creates and initializes its inner components (engine, cargo and tires).

On the first line of input you will receive a number N - the number of cars you have, on each of the next N lines
you will receive information about a car in the format
“<Model> <EngineSpeed> <EnginePower> <CargoWeight> <CargoType> <Tire1Pressure> <Tire1Age> <Tire2Pressure>
<Tire2Age> <Tire3Pressure> <Tire3Age> <Tire4Pressure> <Tire4Age>” where the speed, power, weight and tire age are integers,
tire pressure is a double.
After the N lines you will receive a single line with one of 2 commands “fragile” or “flamable” ,
if the command is “fragile” print all cars whose Cargo Type is “fragile”
with a tire whose pressure is  < 1, if the command is “flamable” print all cars whose Cargo Type is “flamable”
and have Engine Power > 250. The cars should be printed in order of appearing in the input.

 */

package L07ObjectsAndClasses.Exercise.More.T02RawData;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<Car> cars;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        cars = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] data = scanner.nextLine().split("\\s+");
        Car car = new Car(data[0], Integer.parseInt(data[1]), Integer.parseInt(data[2]), // model and engine
                Integer.parseInt(data[3]), data[4],     // Cargo
                Double.parseDouble(data[5]), Integer.parseInt(data[6]),  // tire 1
                Double.parseDouble(data[7]), Integer.parseInt(data[8]), // tire 2
                Double.parseDouble(data[9]), Integer.parseInt(data[10]), // tire 3
                Double.parseDouble(data[11]), Integer.parseInt(data[12])  // tire 4
        );
        cars.add(car);
        }

        String type = scanner.nextLine();

        if (type.equals("fragile")) {
            for (Car car : cars) {
                if(car.isFragile())
                    System.out.println(car.getModel());
            }
        } else {
            for (Car car : cars) {
                if(car.isFlamable()) {
                    System.out.println(car.getModel());
                }
            }
        }

    }
}
