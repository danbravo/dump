package Lesson15;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution5 {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<>();
        while (true) {
            String s = reader.readLine();
            if (s.isEmpty()) break;
            list.add(s);
        }

        String[] array = list.toArray(new String[list.size()]);
        sort(array);

        for (String x : array) {
            System.out.println(x);
        }
    }

    public static void sort(String[] array) {
//        for (int i=0; i<array.length; i++) {
//            if (isNumber(array[i])) {
//                for (int k=0; k<array.length; k++) {
//                    if (isNumber(array[k])) {
//                        if (Integer.valueOf(array[i]) > Integer.valueOf(array[k])) {
//                            String p = array[i];
//                            array[i] = array[k];
//                            array[k] = p;
//                        }
//                    }
//                }
//            } else {
//                for (int k=0; k<array.length; k++) {
//                    if (!isNumber(array[k])) {
//                        if (array[i].compareTo(array[k]) < 0) {
//                            String p = array[i];
//                            array[i] = array[k];
//                            array[k] = p;
//                        }
//                    }
//                }
//            }
//        }

        List<Integer> ints = new LinkedList<>();
        List<String> chars = new LinkedList<>();
        for (String s : array) {
            if (isNumber(s)) {
                ints.add(Integer.valueOf(s));
            } else {
                chars.add(s);
            }
        }

//        Comparator<Integer> compareInts = (i1, i2) -> i1 - i2;
//        Comparator<String> compareChars = String::compareTo;
//        Collections.sort(ints, compareInts);
//        Collections.sort(chars, compareChars);

        ints.sort(Integer::compareTo);
        chars.sort(String::compareTo);

        int j = ints.size();
        int k = 0;
        for (int i=0; i<array.length; i++) {
            if (isNumber(array[i])) {
                array[i] = ints.get(j-1).toString();
                j--;
            } else {
                array[i] = chars.get(k);
                k++;
            }
        }
    }

    public static boolean isGreaterThan(String a, String b) {
        return a.compareTo(b) > 0;
    }

    public static boolean isNumber(String s) {
        if (s.length() == 0) return false;

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if ((i != 0 && c == '-') //есть '-' внутри строки
                    || (!Character.isDigit(c) && c != '-') ) // не цифра и не начинается с '-'
            {
                return false;
            }
        }
        return true;
    }
}
