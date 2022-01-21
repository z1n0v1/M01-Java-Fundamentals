package L07ObjectsAndClasses.Exercise.More.T04TeamworkProjects;

public class User {
    private String name;
    private boolean isInTeam;

    public String getName() {
        return name;
    }

    public User(String name) {
        this.name = name;
        isInTeam = false;
    }

    public boolean isInTeam() {
        return isInTeam;
    }

    public void setInTeam(boolean inTeam) {
        isInTeam = inTeam;
    }
}
