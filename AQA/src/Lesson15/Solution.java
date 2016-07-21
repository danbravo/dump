package Lesson15;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        Set<Cat> cats = createCats();
        Set<Dog> dogs = createDogs();

        Set<Object> pets = join(cats, dogs);
        printPets(pets);

        removeCats(pets, cats);
        printPets(pets);
    }

    public static Set<Cat> createCats() {
        Set<Cat> cats = new HashSet<>();
        cats.add(new Cat("Marty"));
        cats.add(new Cat("Vitya"));
        cats.add(new Cat("Anatolii"));
        cats.add(new Cat("Gus'"));
        return cats;
    }

    public static Set<Dog> createDogs() {
        Set<Dog> dogs = new HashSet<>();
        dogs.add(new Dog("Misha"));
        dogs.add(new Dog("Dog"));
        dogs.add(new Dog("Duck"));
        return dogs;
    }

    public static Set<Object> join(Set<Cat> cats, Set<Dog> dogs) {
        Set<Object> pets = new HashSet<>();
        pets.addAll(cats);
        pets.addAll(dogs);
        return pets;
    }

    public static void removeCats(Set<Object> pets, Set<Cat> cats) {
        pets.removeAll(cats);
    }

    public static void printPets(Set<Object> pets) {
        for (Object pet : pets) {
            System.out.println(pet.toString());
        }
        System.out.println("---------------------");
    }

    public static class Cat {
        String name;
        public Cat(String name) {
            this.name = name;
        }
        @Override
        public String toString() {
            return "Cat name is '" + name + "'";
        }
    }

    public static class Dog {
        String name;
        public Dog(String name) {
            this.name = name;
        }
        @Override
        public String toString() {
            return "Dog name is '" + name + "'";
        }
    }
}
