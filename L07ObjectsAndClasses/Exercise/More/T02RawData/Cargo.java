package L07ObjectsAndClasses.Exercise.More.T02RawData;

public class Cargo {
    private int weight;

    public String getType() {
        return type;
    }

    private String type;

    public Cargo(int weight, String type) {
        this.weight = weight;
        this.type = type;
    }
}
