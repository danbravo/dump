package Lesson6;

import java.util.Arrays;
import java.util.regex.Pattern;

public class SomeTasks {
    public static String charsToString(char[] arr) {
        return Arrays.toString(arr)
                .replace(",", "")
                .replace("[", "")
                .replace("]", "")
                .replace(" ", "")
                .trim();
    }
    public static void main(String[] args) {
//        char[] someChars = {'L', 'E', 'X', 'A', '!', '!'};
//        System.out.println(charsToString(someChars));
        Pattern pattern = Pattern.compile(":|;");
        String[] animals = pattern.split("cat:dog;bird:cow");
        Arrays.asList(animals).forEach(animal -> System.out.print(animal + " "));
        String input = "moom";
        StringBuilder builder = new StringBuilder();
        builder.append(input).reverse();
        String output = builder.toString();
        if (input.equals(output)) {
            System.out.println("is palindrome");
        } else {
            System.out.println("no");
        }
    }
}
