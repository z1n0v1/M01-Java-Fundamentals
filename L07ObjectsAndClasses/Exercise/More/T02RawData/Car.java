package L07ObjectsAndClasses.Exercise.More.T02RawData;

public class Car {
    private String model;
    private Engine engine;
    private Cargo cargo;
    private Tire[] tires;

    public Car(String model, Engine engine, Cargo cargo, Tire[] tires) {
        this.model = model;
        this.engine = engine;
        this.cargo = cargo;
        this.tires = tires;
    }
    public Car(String model, int engineSpeed, int enginePower, int cargoWeight, String cargoType,
               Double tire1Pressure, int tire1Age, Double tire2Pressure, int tire2Age,
               Double tire3Pressure, int tire3Age, Double tire4Pressure, int tire4Age) {
        this.model = model;
        Engine engine = new Engine(engineSpeed,enginePower);
        Cargo cargo = new Cargo(cargoWeight, cargoType);
        Tire[] tires = new Tire[4];
        tires[0] = new Tire(tire1Pressure,tire1Age);
        tires[1] = new Tire(tire2Pressure,tire2Age);
        tires[2] = new Tire(tire3Pressure,tire3Age);
        tires[3] = new Tire(tire4Pressure,tire4Age);

        this.engine = engine;
        this.cargo = cargo;
        this.tires = tires;
    }

    public String getModel() {
        return model;
    }

    public boolean isFragile() {
        if(cargo.getType().equals("fragile")) {
            for (Tire tire : tires)
                if (tire.getPressure() < 1)
                    return true;
        }
        return false;
    }

    public boolean isFlamable() {
        if(cargo.getType().equals("flamable")) {
            if (engine.getPower() > 250)
                return true;
        }
        return false;
    }
}
