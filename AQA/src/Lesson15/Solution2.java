package Lesson15;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution2 {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<String> list = new ArrayList<>();

        String line = null;
        while (!(line = reader.readLine()).equals("")) {
            list.add(line);
        }
        sort(list);
        System.out.println(list);
    }

    public static void sort(List<String> list) {
//        list.stream()
//                .filter(p -> isGreaterThan(p, list.get(list.indexOf(p+1))))
//                .forEach(p -> {
//                    String temp = p;
//                    list.set(list.indexOf(p), list.get(list.indexOf(p+1)));
//                    list.set(list.indexOf(p+1), temp);
//                });
        list.sort(String::compareTo);
    }

    public static boolean isGreaterThan(String a, String b) {
        return a.compareTo(b) > 0;
    }
}
