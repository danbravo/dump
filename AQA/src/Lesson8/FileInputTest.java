package Lesson8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileInputTest {

    public static void buffReadUntilStop() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            String input = "";
            while(!input.equals("stop")) {
                System.out.println("Enter data:");
                input = br.readLine();
                System.out.println("Data is: "+input);
            }
        } catch (IOException e) {
            System.err.println("Error: "+e.getMessage());
        }
    }

    public static void buffRead() {
        try (BufferedReader br = new BufferedReader
                (new InputStreamReader(System.in))) {
            System.out.println("Enter your name:");
            String name = br.readLine();
            System.out.println("Welcome "+name);
        } catch (IOException e) {
            System.err.println("Error: "+e.getMessage());
        }
    }

    public static void main(String[] args) {
        buffReadUntilStop();
    }
}
