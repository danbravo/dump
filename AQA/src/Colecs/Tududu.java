package Colecs;

import org.testng.annotations.Test;

import java.util.*;

public class Tududu {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("first");
        list.add("second");
        list.add("third");
        list.add("fourth");
        list.add("fifth");

        list.forEach(System.out::println);

        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String text = iterator.next();
            System.out.println(text);
        }

        for(int i=1; i<100; i++) {
            System.out.println(i%3==0 ? (i%5==0 ? "FizzBuzz" : "Fizz") : (i%5==0 ? "Buzz" : i));
        }
    }

    @Test
    public void sets() {
        Set<String> set = new HashSet<>();
        set.add("c");
        set.add("a");
        set.add("b");
        System.out.println(set);

        Set<String> set2 = new TreeSet<>();
        set2.add("c");
        set2.add("a");
        set2.add("b");
        System.out.println(set2);

        Set<String> set1 = new LinkedHashSet<>();
        set1.add("c");
        set1.add("a");
        set1.add("b");
        System.out.println(set1);

        set1.stream().forEach(System.out::println);
    }

    @Test
    public void mapMethod() {
        Map<String, String> map = new HashMap<>();
        map.put("first", "Mama");
        map.put("second", "Mila");
        map.put("third", "Ramu");

        for (Map.Entry<String, String> pair : map.entrySet()) {
            String key = pair.getKey();
            String value = pair.getValue();
            System.out.println(key + ";" + value);
        }

        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
        map.put("first", "Mama");
        map.put("second", "Mila");
        map.put("third", "Ramu");

        while (iterator.hasNext()) {
            Map.Entry<String, String> pair = iterator.next();
            String key = pair.getKey();
            String value = pair.getValue();
            System.out.println(key + ";" + value);
        }
    }

    @Test
    public void someMeth() {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");

        List<String> bc = new ArrayList<>();
        bc.add("a");
        bc.add("b");

        System.out.println(list.containsAll(bc));
    }

    @Test
    public void tryRemove() {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");

//        for (String s : list) {
//            if (s.equals("a")) {
//                list.remove(s);
//            }
//        }

        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().equals("a")) {
                iterator.remove();
            }
        }

        for (int i=0; i<list.size(); i++) {
            if (list.get(i).equals("a")) {
                list.set(i, "z");
            }
        }
    }

    @Test
    public void tryCollWithMyObject() {
        List<Person> list = new ArrayList<>();

        list.add(new Person("Lesha", 12, Person.Gender.MALE, 1000));
        list.add(new Person("Petya", 9, Person.Gender.MALE, 120));
        list.add(new Person("Misha", 6, Person.Gender.MALE, 200));
        list.add(new Person("Kesha", 50, Person.Gender.FEMALE, 50));

        for (Person i : list) {
            System.out.print(i.name + " ");
            System.out.println(i.age);
        }
    }

    @Test
    public void lalal() {
        Map<String, Integer> someMap = new TreeMap<>();

        someMap.put("lalalal", 10);
        someMap.put("urururu", 99);
        someMap.put("etetete", 5);
        someMap.put("tregtretre", 554);
        someMap.put("rererere", 2);

        someMap.forEach((e1, e2) -> System.out.println("key: "+e1+" value: "+e2));

        System.out.println(someMap.get("lalalal"));

        List<Map.Entry<String, Integer>> vals = new ArrayList<>(someMap.entrySet());
        System.out.println(vals);

    }
}
