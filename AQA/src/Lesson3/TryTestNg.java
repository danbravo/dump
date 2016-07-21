package Lesson3;

import org.testng.annotations.Test;
import java.util.Scanner;

public class TryTestNg {
    public static final double PI = 3.14;
    public static final String ERROR_MSG = "My error msg";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double r = sc.nextDouble();

        double area = PI*r*r;

        System.out.println(ERROR_MSG);
        System.out.println("Area of circle is: " + "\n" + area);
    }

    @Test
    public void tryIt() {
        int a = 4;
        int b = 5;
        boolean result;
        result = a == b; // a равно b - false
        result = a != b; // a не равно b - true
        result = a < b; // a меньше b - true
        result = a > b; // a больше b - false
        result = a <= 4; // a меньше или равно 4 - true
        result = b >= 6; // b больше или равно 6 - false
        result = a > b || a < b; // (a больше b) логическое или (a меньше b) - true
        result = 3 < a && a < 6; // (3 меньше a) логическое и(a меньше 6) - true
        result = !result; // логическое не - false
    }
}
