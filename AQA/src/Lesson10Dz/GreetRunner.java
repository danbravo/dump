package Lesson10Dz;

import java.util.ArrayList;
import java.util.List;

public class GreetRunner {
    static List<Human> human;

    public static void main(String[] args) {
        human = new ArrayList<>();
        human.add(new Russian("Vas9"));
        human.add(new American("George"));
        human.add(new Spanish("Pedro"));
        human.add(new Ukrainian("Mukola"));

        human.forEach(Human::sayHello);
    }
}
