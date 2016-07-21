package JavaTasks;

public class DataTypes {

    public static void getModulo(int a, int b) {
        System.out.println(a%b);
    }

    public static int sumOfNumber(int a) {
        int s = 0;
        while (a != 0 ) {
            s = s + (a % 10);
            a /= 10;
        }
        return s;
    }

    public static void main(String[] args) {
        getModulo(10, 7);
        System.out.println(sumOfNumber(154));
        System.out.println(Math.round(2.49));
    }
}
