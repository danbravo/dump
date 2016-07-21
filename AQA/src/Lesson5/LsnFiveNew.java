package Lesson5;

import java.util.Arrays;

public class LsnFiveNew {
    public static void main(String[] args) {
        char[] array = new char[255];
        for (int i=0; i<array.length; i++) {
            array[i] = (char) i;
        }
        String stringOfChars = Arrays.toString(array);
        System.out.println(stringOfChars);
    }
}
