package Lesson13;

import java.util.Arrays;
import java.util.Random;

public class SudokuInsides {
    private int[][] values = new int[9][9];

    public void generateFld() {
        for (int[] v : values) {
            int k=1;
            for (int i=0; i<v.length; i++) {
                v[i] = k++;
            }
            shuffleArray(v);
            deleteNumbersEasy(v);
            shuffleArray(v);
        }

        for (int[] v : values) {
            for (int i=0; i<v.length; i++) {

            }
        }
        System.out.println(Arrays.deepToString(values));
    }

//    private boolean checkLine(int arrIndex, int numIndex) {
//        boolean b = true;
//        for (int[] v : values) {
//            for (int i=arrIndex; i<3; i++) {
//                if (v[i]==n) {
//                    b = false;
//                }
//            }
//        }
//        return b;
//    }
//
//    private boolean checkColumn(int n) {
//        boolean b = true;
//        for (int[] v : values) {
//
//        }
//    }

    private void deleteNumbersEasy(int[] array) {
        for (int i=0; i<3; i++) {
            array[i] = 0;
        }
    }

    private void deleteNumbersMedium(int[] array) {
        for (int i=0; i<4; i++) {
            array[i] = 0;
        }
    }

    private void deleteNumbersHard(int[] array) {
        for (int i=0; i<5; i++) {
            array[i] = 0;
        }
    }

    private void shuffleArray(int[] array) {
        int index, temp;
        Random random = new Random();
        for (int i=array.length-1; i>0; i--)
        {
            index = random.nextInt(i+1);
            temp = array[index];
            array[index] = array[i];
            array[i] = temp;
        }
    }
}
