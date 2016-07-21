package Colecs;

public class Person {

    public enum Gender {
        MALE, FEMALE, SHEMALE
    }

    public String name;
    public int age;
    public int salary;
    public Gender gender;

    public Person(String name, int age, Gender gender, int salary) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.salary = salary;

    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Gender getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return name + " "
                + age + " "
                + gender + " "
                + salary;
    }
}
