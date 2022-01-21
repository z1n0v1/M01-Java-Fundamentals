package L07ObjectsAndClasses.Exercise.T05Students;

public class Student {
    private String firstName, lastName;
    private double grade;

    public Student(String firstName, String lastName, double grade) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.grade = grade;
    }

    public double getGrade() {
        return grade;
    }

    public String toString() {
        return String.format("%s %s: %.2f", firstName, lastName, grade);
    }
}
