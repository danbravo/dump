package Lesson5;

import java.util.Arrays;

public class LsnFive {
    public static final int SIZE = 10;
    public static void main(String[] args) {
        int[] a = {123, 654, 72, 7, 7, 433, 95};
        boolean swapOcc = true;

        while(swapOcc) {
            swapOcc = false;
            for (int i = 0; i < a.length - 1; i++) {
                if (a[i] > a[i + 1]) {
//                    int tempVar = a[i];
//                    a[i] = a[i + 1];
//                    a[i + 1] = tempVar;
                    a[i] = a[i] ^ a[i + 1];
                    a[i + 1] = a[i] ^ a[i + 1];
                    a[i] = a[i] ^ a[i + 1];
                    swapOcc = true;
                }
            }
        }

        System.out.println(Arrays.toString(a)
                .replace("[", "").replace("]", "").replace(",", ""));
    }
}
