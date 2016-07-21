package Lesson4;

import java.util.Arrays;
import java.util.List;

public class TestLesson {
    public static void main(String[] args) {
//        int count = 0;
//        for (int i=0; i<=20; i++) {
//            if (i%2==0) {
//               System.out.println(i);
//               count++;
//            }
//        }
//        System.out.println(count);

        List<String> someLists = Arrays.asList("asdasd", "AAAAAAAAA", "IFIFIFIF");
        someLists.stream().filter(s -> s.contains("a")).forEach(s -> System.out.println(s));
    }
}
