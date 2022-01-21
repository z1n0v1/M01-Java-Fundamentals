package L07ObjectsAndClasses.Exercise.T06VehicleCatalogue;

public class Vehicle {
    private String typeOfVehicle, model, color;
    int horsepower;

    public Vehicle(String typeOfVehicle, String model, String color, int horsepower) {
        this.typeOfVehicle = typeOfVehicle;
        this.model = model;
        this.color = color;
        this.horsepower = horsepower;
    }

    public String toString() {
        String carOrTruck = typeOfVehicle.equals("car") ? "Car" : "Truck";
        return String.format("Type: %s%nModel: %s%nColor: %s%nHorsepower: %d", carOrTruck, model, color, horsepower);
    }

    public String getTypeOfVehicle() {
        return typeOfVehicle;
    }

    public int getHorsepower() {
        return horsepower;
    }

    public String getModel() {
        return model;
    }

    public boolean equals(Object o) {
        if (o instanceof Vehicle) {
            Vehicle vehicle = (Vehicle) o;
            return model.equals(vehicle.getModel());
        }
        return false;
    }
}
