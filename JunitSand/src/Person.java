
import java.io.Serializable;

// implements Serializable interface
public class Person implements Serializable {

    // Private attributes
    private String name;
    private int age;
    private int weight;

    // Public Constructor (without parameters or in other words empty)
    public Person() {
    }

    public Person(String name, int age, int weight) {
        this.name = name;
        this.age = age;
        this.weight = weight;
    }

    // Getter for name
    public String getName() {
        return this.name;
    }

    // Setter for name
    public void setName(String name) {
        this.name = name;
    }

    // Getter for age
    public int getAge() {
        return this.age;
    }

    // Setter for age
    public void setAge(int age) {
        this.age = age;
    }

    // Getter for weight
    public int getWeight() {
        return this.weight;
    }

    // Setter for weight
    public void setWeight(int weight) {
        this.weight = weight;
    }

}