package L07ObjectsAndClasses.Lab.T05Students;

public class Student {
    String firstName, lastName, homeTown;
    int age;

    public Student(String firstName, String lastName, int age, String homeTown) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.homeTown = homeTown;
        this.age = age;
    }

    public String toString() {
        return String.format("%s %s is %d years old", firstName, lastName, age);
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setHomeTown(String homeTown) {
        this.homeTown = homeTown;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getHomeTown() {
        return homeTown;
    }

    public int getAge() {
        return age;
    }
}
