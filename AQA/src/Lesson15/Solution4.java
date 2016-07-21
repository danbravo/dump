package Lesson15;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Solution4 {
    public static void main(String[] args)
    {
        Map<String, Cat> map = createMap();
        Set<Cat> set = convertMapToSet(map);
        printCatSet(set);
    }

    public static Map<String, Cat> createMap() {
        Map<String, Cat> catMap = new HashMap<>();
        catMap.put("Marty", new Cat("Marty"));
        catMap.put("Dudie", new Cat("Dudie"));
        catMap.put("Bam", new Cat("Bam"));
        catMap.put("Rex", new Cat("Rex"));
        catMap.put("Vasya", new Cat("Vasya"));
        catMap.put("Lexa", new Cat("Lexa"));
        catMap.put("Norm", new Cat("Norm"));
        catMap.put("Borm", new Cat("Borm"));
        catMap.put("Igor", new Cat("Igor"));
        catMap.put("Kot", new Cat("Kot"));
        return catMap;
    }

    public static Set<Cat> convertMapToSet(Map<String, Cat> map) {
        return map.entrySet().stream().map(Map.Entry::getValue).collect(Collectors.toSet());
    }

    public static void printCatSet(Set<Cat> set) {
        set.forEach(System.out::println);
    }

    public static class Cat
    {
        private String name;

        public Cat(String name)
        {
            this.name = name;
        }

        public String toString()
        {
            return "Cat "+this.name;
        }
    }
}
