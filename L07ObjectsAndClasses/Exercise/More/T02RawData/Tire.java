package L07ObjectsAndClasses.Exercise.More.T02RawData;

public class Tire {
    private double pressure;
    private int age;

    public double getPressure() {
        return pressure;
    }

    public Tire(double pressure, int age) {
        this.pressure = pressure;
        this.age = age;
    }
}
