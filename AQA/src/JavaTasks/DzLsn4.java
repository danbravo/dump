package JavaTasks;

public class DzLsn4 {

    public static void taskOne() {
        int count = 0;
        for (int i=1000; i<10000; i+=3) {
            count++;
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println("Number of digits: " + count);
    }
    public static void taskTwo() {
        int count = 0;
        for (int i=1; i<110; i+=2) {
            count++;
            System.out.print(i + " ");
        }
        System.out.println("\n" + count);
    }
    public static void taskThree() {
        for (int i=90; i>=0; i-=5) {
            System.out.print(i + " ");
        }
    }
    public static void taskFour() {
        int count = 0;
        int i = 2;
        while (count<20) {
            System.out.println(i + " ");
            i*=2;
            count++;
        }
    }
    public static void taskFive() {
        int[][] numbers = new int[8][5];
        for (int i=0; i<numbers.length; i++) {
            for (int k=0; k<numbers[i].length; k++) {
                numbers[i][k] = (int) (Math.random()*(99 - 10) + 10);
            }
        }
        for (int i=0; i<8; i++) {
            for (int k=0; k<5; k++) {
                System.out.print(numbers[i][k] + "\t");
            }
            System.out.println();
        }
    }
    public static void taskSix() {
        int[][] nums = new int[5][8];
        for (int i=0; i<nums.length; i++) {
            for (int k=0; k<nums[i].length; k++) {
                nums[i][k] = (int) (-99 + Math.random()*(99+99+1));
            }
        }
        for (int i=0; i<5; i++) {
            for (int k=0; k<8; k++) {
                System.out.print(nums[i][k] + "\t");
            }
            System.out.println();
        }
        int max = nums[0][0];
        for (int i=0; i<nums.length; i++) {
            for (int k=0; k<nums[i].length; k++) {
                if (max < nums[i][k]) {
                    max = nums[i][k];
                }
            }
        }
        System.out.println("Max int is: " + max);
    }
    public static void main(String[] args) {
        taskSix();
    }
}
