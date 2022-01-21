/*
    https://judge.softuni.org/Contests/Practice/Index/1328#2

   03. Car Salesman

Define two classes Car and Engine. A Car has a model, engine, weight and color.
An Engine has model, power, displacement and efficiency.
A Car’s weight and color and its Engine’s displacements and efficiency are optional.

On the first line, you will read a number N which will specify how many lines of engines you will receive,
on each of the next N lines you will receive information about an Engine in the following format
“<Model> <Power> <Displacement> <Efficiency>”.
After the lines with engines, on the next line you will receive a number M – specifying the number of Cars that will follow,
on each of the next M lines information about a Car will follow in the following format “<Model> <Engine> <Weight> <Color>”,
where the engine in the format will be the model of an existing Engine.
When creating the object for a Car, you should keep a reference to the real engine in it, instead of just the engine’s model,
note that the optional properties might be missing from the formats.

Your task is to print each car (in the order you received them) and its information in the format defined bellow,
if any of the optional fields has not been given print "n/a" in its place instead:
<CarModel>:
<EngineModel>:
Power: <EnginePower>
Displacement: <EngineDisplacement>
Efficiency: <EngineEfficiency>
Weight: <CarWeight>
Color: <CarColor>

Optional
Override the classes’s ToString() methods to have a reusable way of displaying the objects.

 */

package L07ObjectsAndClasses.Exercise.More.T03CarSalesman;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    private static Pattern pattern;
    private static List<Engine> engines;
    private static List<Car> cars;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        pattern = Pattern.compile("-?\\d+(\\.\\d+)?");
        engines = new ArrayList<>();
        cars = new ArrayList<>();

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] data = scanner.nextLine().split("\\s+");
            Engine engine;

            if(data.length == 4) {
                engine = new Engine(data[0], Integer.parseInt(data[1]), Integer.parseInt(data[2]), data[3]);
            } else if(data.length == 3) {
                if(isNumeric(data[2])) {
                    engine = new Engine(data[0], Integer.parseInt(data[1]), Integer.parseInt(data[2]));
                } else {
                    engine = new Engine(data[0], Integer.parseInt(data[1]), data[2]);
                }
            } else {
                engine = new Engine(data[0], Integer.parseInt(data[1]));
            }
            engines.add(engine);
        }

        int m = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < m; i++) {
            String[] data = scanner.nextLine().split("\\s+");
            Car car;

            if(data.length == 4) {
                car = new Car(data[0], getEngine(data[1]), Integer.parseInt(data[2]), data[3]);
            } else if(data.length == 3) {
                if(isNumeric(data[2]))
                    car = new Car(data[0], getEngine(data[1]), Integer.parseInt(data[2]));
                else car = new Car(data[0], getEngine(data[1]), data[2]);
            } else car = new Car(data[0], getEngine(data[1]));
            cars.add(car);
        }

        for (Car car : cars)
            System.out.println(car);

    }

    private static Engine getEngine(String model) {
        Engine engine = new Engine(model,-1);
        return engines.get(engines.indexOf(engine));
    }

    private static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        return pattern.matcher(strNum).matches();
    }
}
