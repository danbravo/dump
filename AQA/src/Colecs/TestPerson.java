package Colecs;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class TestPerson {
    public static void main(String[] args) {
        List<Person> list = new ArrayList<>();

        list.add(new Person("Lesha", 12, Person.Gender.MALE, 1000));
        list.add(new Person("Petya", 9, Person.Gender.MALE, 4000));
        list.add(new Person("Misha", 6, Person.Gender.MALE, 200));
        list.add(new Person("Kesha", 50, Person.Gender.FEMALE, 126));
        list.add(new Person("Ananya", 12, Person.Gender.SHEMALE, 750));
        list.add(new Person("ZORB", 999, Person.Gender.FEMALE, 450));
        list.add(new Person("GOB", 1, Person.Gender.FEMALE, 2999));
        list.add(new Person("DADA", 122, Person.Gender.MALE, 150));

        Comparator<Person> byName = (p1, p2) -> p1.getName().compareTo(p2.getName());
        Comparator<Person> byNameLength = (p1, p2) -> p1.getName().length() - p2.getName().length();
        Comparator<Person> byAge = (p1, p2) -> p1.getAge() - p2.getAge();
        Comparator<Person> byGender = (p1, p2) -> p1.getGender().compareTo(p2.getGender());
        Comparator<Person> bySalary = (p1, p2) -> p1.getSalary() - p2.getSalary();

        Consumer<Person> raiseSalary = p -> p.setSalary((p.getSalary() / 100) * 5 + p.getSalary());

        //filters
        Predicate<Person> ageFilter = p -> p.getAge() >= 21;
        Predicate<Person> genderFilter = p -> p.getGender() == Person.Gender.MALE;
        Predicate<Person> salaryFilter = p -> p.getSalary() > 1000;

//        list.forEach(raiseSalary);
        list.sort(bySalary);
        list.stream()
                .filter(genderFilter)
                .forEach(p -> System.out.println(p));

        List<Person> sortedByName = list.stream()
                .sorted(byName)
                .collect(Collectors.toList());

        //get the lowest person salary
        Person pers = list.stream()
                .min(bySalary)
                .get();

//        List<String> l2 = new ArrayList<>();
//
//        list.stream()
//                .filter(p -> p.getGender() == Person.Gender.MALE)
//                .map(p -> p.getName())
//                .forEach(name -> l2.add(name));
//
//        System.out.println(l2);
//
//        TestInterface test = message -> System.out.println("hi " + message);
//        test.say("DICK");
//
//        Runnable r = () -> System.out.println("hi");
//        r.run();
    }
}
