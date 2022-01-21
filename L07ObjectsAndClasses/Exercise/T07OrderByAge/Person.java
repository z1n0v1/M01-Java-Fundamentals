package L07ObjectsAndClasses.Exercise.T07OrderByAge;

public class Person {
    String name, id;
    int age;

    public int getAge() {
        return age;
    }

    public Person(String name, String id, int age) {
        this.name = name;
        this.id = id;
        this.age = age;
    }

    public String toString() {
        return String.format("%s with ID: %s is %d years old.", name, id, age);
    }
}
