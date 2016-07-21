package Lesson1;

import java.util.Scanner;

public class HelloWorldRunner {

    static {
        System.out.println("hello world");
    }

    public static boolean palindrome(String s) {
        boolean isPalindrome = true;
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
                isPalindrome = false;
                break;
            }
        }
        return isPalindrome;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        while (running) {
            String input = scanner.nextLine()
                    .replace(" ", "")
                    .replace(",", "")
                    .toLowerCase();
            if (!(input.equalsIgnoreCase("stop"))) {
                if (palindrome(input)) {
                    System.out.println("a palindrome");
                } else {
                    System.out.println("not a palindrome");
                }
            } else {
                System.out.println("c'ya!");
                running = false;
            }
        }
    }
}
