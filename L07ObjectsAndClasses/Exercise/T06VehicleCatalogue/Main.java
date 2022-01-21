/*
    https://judge.softuni.org/Contests/Practice/Index/1327#5

    06. Vehicle Catalogue

You have to make a catalogue for vehicles. You will receive two types of vehicle - car or truck.
Until you receive the command "End" you will receive lines of input in the format:
{typeOfVehicle} {model} {color} {horsepower}
After the "End" command, you will start receiving models of vehicles.

Print for every received vehicle its data in the format:
Type: {typeOfVehicle}
Model: {modelOfVehicle}
Color: {colorOfVehicle}
Horsepower: {horsepowerOfVehicle}

When you receive the command "Close the Catalogue", stop receiving input and print the average horsepower for the cars
and for the trucks in the format:
"{typeOfVehicles} have average horsepower of {averageHorsepower}."

The average horsepower is calculated by dividing the sum of horsepower for all vehicles of the type
by the total count of vehicles from the same type.

Format the answer to the 2nd decimal point.

Constraints
•	The type of vehicle will always be car or truck
•	You will not receive the same model twice
•	The received horsepower will be integer in the interval [1…1000]
•	You will receive at most 50 vehicles
•	Single whitespace will be used for separator
 */

package L07ObjectsAndClasses.Exercise.T06VehicleCatalogue;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Vehicle> vehicles = new ArrayList<>();
        String input = scanner.nextLine();
        double allCarsHorsePower = 0, allTrucksHorsepower = 0, numCars = 0, numTrucks = 0;
        while (!input.equals("End")) {
            String[] data = input.split("\\s+");
            int horsepower = Integer.parseInt(data[3]);
            if (data[0].equals("car")) {
                allCarsHorsePower += horsepower;
                numCars++;
            } else {
                allTrucksHorsepower += horsepower;
                numTrucks++;
            }
            vehicles.add(new Vehicle(data[0], data[1], data[2], horsepower));
            input = scanner.nextLine();
        }
        input = scanner.nextLine();
        while (!input.equals("Close the Catalogue")) {
            Vehicle modelVehicle = new Vehicle("", input, "", 0);
            System.out.println(vehicles.get(vehicles.indexOf(modelVehicle)));
            input = scanner.nextLine();
        }
        double carHorsepower = 0, truckHorsepower = 0;
        if ( numCars > 0) carHorsepower = allCarsHorsePower / numCars;
        if (numTrucks > 0) truckHorsepower =  allTrucksHorsepower / numTrucks;

        System.out.printf("Cars have average horsepower of: %.2f.%n", carHorsepower);
        System.out.printf("Trucks have average horsepower of: %.2f.%n", truckHorsepower);
    }
}
