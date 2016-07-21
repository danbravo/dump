package Lesson9;

public class SomeShitClass {

    public static void main(String[] args) {
        Student student = new Student("MISHA", "Univer");
        student.setGroup("Some group");
        System.out.println(student.getGroup());
        String response = student.getResponse("What is class?");
        System.out.println(response);
    }
}
