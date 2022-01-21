package L07ObjectsAndClasses.Exercise.More.T03CarSalesman;

public class Engine {
    private String model;
    private int power, displacement;
    private String efficiency;

    public Engine(String model, int power, int displacement, String efficiency) {
        this.model = model;
        this.power = power;
        this.displacement = displacement;
        this.efficiency = efficiency;
    }

    public Engine(String model, int power, int displacement) {
        this(model, power, displacement, "n/a");
    }

    public Engine(String model, int power, String efficiency) {
        this(model, power, -1, efficiency);
    }

    public Engine(String model, int power) {
       this(model, power, -1, "n/a");
    }

    public String getModel() {
        return model;
    }

    public boolean equals(Object o) {
        if (o instanceof Engine) {
            Engine engine = (Engine) o;
            if(engine.getModel().equals(model))
                return true;
        }
        return false;
    }

    public String toString() {

        String string = String.format("%s:%nPower: %d%nDisplacement: ",model,power);
        if ( displacement == -1)
            string+=String.format("n/a%n");
        else string+=String.format("%d%n",displacement);
        string += String.format("Efficiency: %s",efficiency);

        return string;

        //        return model + ":\n"
//                +"Power: " + power + "\n"
//                + "Displacement: " + ((displacement == -1) ? "n/a" : displacement) + "\n"
//                + "Efficiency: " + efficiency;

    }
}
