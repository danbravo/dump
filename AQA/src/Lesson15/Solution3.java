package Lesson15;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution3 {
    public static void main(String[] args) throws Exception {
        List<Integer> integerList = getIntegerList();
        System.out.println(getMinimum(integerList));
    }

    public static int getMinimum(List<Integer> list) {
//        list.stream().min(Comparator.naturalOrder());
//        Integer min = list.get(0);
//        for (Integer i : list) {
//            if (min > i) {
//                min = i;
//            }
//        }
        return list.stream().min(Integer::compare).get();
    }

    public static List<Integer> getIntegerList() throws IOException {
        Scanner sc = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();

        int intNum = sc.nextInt();
        byte i = 0;
        while (i < intNum) {
            list.add(sc.nextInt());
            i++;
        }
        return list;
    }
}
