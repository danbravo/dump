package JavaTasks;

import com.google.common.primitives.Ints;

import java.util.Arrays;
import java.util.Random;

public class DzLsn5 {
    //task1
    public static char[] delNonAlfChars(char[] arr) {
        StringBuilder builder = new StringBuilder();
        for (char ch : arr) {
            if (Character.isAlphabetic(ch)) {
                builder.append(ch);
            }
        }
        return String.valueOf(builder).toCharArray();
    }

    //task2
    public static String fourDimArr(int dim1, int dim2, int dim3, int dim4) {
        int[][][][] intArr = new int[dim1][dim2][dim3][dim4];
        int i=0;
        StringBuilder builder = new StringBuilder();
        for (int a=0; a<intArr.length; a++) {
            for(int b=0; b<intArr[a].length; b++) {
                for(int c=0; c<intArr[a][b].length; c++) {
                    for(int d=0; d<intArr[a][b][c].length; d++) {
                        intArr[a][b][c][d] = i++;
                        builder.append(intArr[a][b][c][d] + "\t");
                    }
                    builder.append("\n");
                }
                builder.append("\n");
            }
            builder.append("\n");
        }
        return builder.toString();
    }

    //task3
    public static void maxValueOfArr(int max, int min) {
        Random random = new Random();
        int[] array = new int[12];
        for (int i=0; i<array.length; i++) {
            array[i] = random.nextInt(max - min + 1) + min;
        }
        int maxVal = array[0];
        for (int k=0; k<array.length; k++) {
            if (maxVal < array[k]) {
                maxVal = array[k];
            }
        }
        int m = Ints.indexOf(array, maxVal);
        System.out.println("Highest number is " + maxVal + "\nIt's index is " + m);
    }

    //task4
    public static void mostOccurringNum(int max, int min) {
        Random random = new Random();
        int[] intArr = new int[11];
        for(int i=0; i<intArr.length; i++) {
            intArr[i] = random.nextInt(max - min + 1) + min;
        }
        int one = 0;
        int zero = 0;
        int negOne = 0;
        for(int k=0; k<intArr.length; k++) {
            if (intArr[k]==1) {
                one++;
            } else if(intArr[k]==0) {
                zero++;
            } else {
                negOne++;
            }
        }
        if (one>zero & one>negOne) {
            System.out.println("Most occurring digit in array is 1\nOccured " + one + " times");
        } else if (zero>one & zero>negOne) {
            System.out.println("Most occurring digit in array is 0\nOccured " + zero + " times");
        } else if (negOne>one & negOne>zero) {
            System.out.println("Most occurring digit in array is -1\nOccured " + negOne + " times");
        }
    }

    //task5
    public static int[] descInsertionSort(int[] array) {
        int t;
        int i,j;
        for (i=1; i<array.length; i++) {
            t = array[i];
            for (j=i-1; j>=0 && array[j]<t; j--) {
                array[j+1] = array[j];
            }
            array[j+1] = t;
        }
        return array;
    }

    //task7
    public static void multTable() {
        int[] first = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] second = new int[10];
        System.out.println(Arrays.toString(first)
                .replace("[", "")
                .replace("]", "")
                .replace(",", "\t"));
        for (int k=1; k<10; k++) {
            for (int i=1; i<first.length; i++) {
                second[0] = k;
                second[i] = first[i]*second[0];
            }
            System.out.println(Arrays.toString(second)
                    .replace("[", "")
                    .replace("]", "")
                    .replace(",", "\t"));
        }
    }

    public static void main(String[] args) {
        System.out.println(fourDimArr(10, 10, 10, 10)); //task2
        maxValueOfArr(15, -15); //task3
        mostOccurringNum(1, -1); //task4
        int[] someArr = {7, 8, 19, 65, 4, 22, 9}; //task5
        descInsertionSort(someArr);
        System.out.println(Arrays.toString(someArr));
        multTable(); //task7

    }
}
