package Lesson6;

import java.util.Scanner;

public class Dz {

    //task1
    public static String delSpaces(String s) {
        StringBuilder builder = new StringBuilder();
        for (int i=0; i<s.length(); i++) {
            if (!(s.charAt(i)==' ')) {
                builder.append(s.charAt(i));
            }
        }
        return builder.toString();
    }

    //task2
    public static String wordAfterNew(String s) {
        String found = "";
        for (int i=0; i<s.length()-"new".length(); i++) {
            if ((s.charAt(i)=='n' | s.charAt(i)=='N')
                    & (s.charAt(i+1)=='e' | s.charAt(i+1)=='E')
                    & (s.charAt(i+2)=='w' | s.charAt(i+2)=='W')) {
                StringBuilder builder = new StringBuilder();
                String targetStr = builder
                        .append(s.charAt(i))
                        .append(s.charAt(i+1))
                        .append(s.charAt(i+2)).toString();
                int begin = s.indexOf(targetStr) + targetStr.length();
                found = s.substring(begin, s.length());
            }
        }
        return found;
    }

    //task3
    public static void sumOfDigits() {
        Scanner sc = new Scanner(System.in);
        String[] digits = sc.nextLine().split(",");
        int sum = 0;
        for (int i=0; i<digits.length; i++) {
            sum += Integer.parseInt(digits[i].trim());
        }
        System.out.println("Sum of input is: " + sum);
    }

    //task4 method
    public static void lexCompare(String f, String s) {
        int i = f.compareTo(s);
        if (i==0) {
            System.out.println("String are lexicographically even");
        } else if (i<0) {
            System.out.println("Second string is greater than first one");
        } else {
            System.out.println("First string is greater than the second one");
        }
    }

    //task4 method
    public static void ignoreCaseCompare(String f, String s) {
        if (f.equalsIgnoreCase(s)) {
            System.out.println("Strings are even");
        } else {
            System.out.println("Strings are not even");
        }
    }

    //task4 method
    public static void ignoreSpacesCompare(String f, String s) {
        if (f.replaceAll(" ", "").equals(s.replaceAll(" ", ""))) {
            System.out.println("Strings are even");
        } else {
            System.out.println("Strings are not even");
        }
    }

    public static void main(String[] args) {
        final Scanner scInt = new Scanner(System.in);
        String str1, str2;
        int number;
        do {
            System.out.println("Choose the comparing methods:\n1. Lexicographical compare\n2. Compare ignoring case\n3. Compare ignoring spaces");
            while (!scInt.hasNextInt()) {
                System.out.println("That's not a number");
                scInt.nextLine();
            }
            number = scInt.nextInt();
        } while (number<0 || number>3);

        final Scanner scStr = new Scanner(System.in);
        if (number==1) {
            System.out.println("Enter the first string:");
            str1 = scStr.nextLine();
            System.out.println("Enter the second string:");
            str2 = scStr.nextLine();
            lexCompare(str1, str2);
        } else if (number==2) {
            System.out.println("Enter the first string:");
            str1 = scStr.nextLine();
            System.out.println("Enter the second string:");
            str2 = scStr.nextLine();
            ignoreCaseCompare(str1, str2);
        } else if (number==3) {
            System.out.println("Enter the first string:");
            final String fString = scStr.nextLine();
            System.out.println("Enter the second string:");
            final String sString = scStr.nextLine();
            ignoreSpacesCompare(fString, sString);
        }
    }
}

