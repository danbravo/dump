package JavaTasks;

import java.util.Scanner;

public class TaskOne {
    public static void charToInt(String a) {
        int[] ints = new int[a.length()];
        for (int i = 0; i < a.length(); i ++) {
            char c = a.charAt(i);
            ints[i] = Character.getNumericValue(c);
        }
        for (int e : ints) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        charToInt(input);
    }

}
