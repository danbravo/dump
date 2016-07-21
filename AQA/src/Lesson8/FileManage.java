package Lesson8;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileManage {

    public static void writeToFile(String path, String text) {

        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path)))) {
            writer.append(text);
            writer.newLine();
        } catch (FileNotFoundException e) {
            System.err.println("No such file!");
        } catch (IOException e) {
            System.err.println("IOException!" + e.getMessage());
        }
    }

    public static void updateFile(String filePath, String toUpdate) {
        String text;
        StringBuilder tempText = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            while((text = reader.readLine()) != null) {
                tempText.append(text);
            }
        } catch (FileNotFoundException e) {
            System.err.println("No such file!");
        } catch (IOException e) {
            System.err.println("IOException!" + e.getMessage());
        }

        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filePath)))) {
            writer.append(tempText);
            writer.newLine();
            writer.append(toUpdate);
            writer.newLine();
        } catch (FileNotFoundException e) {
            System.err.println("No such file!");
        } catch (IOException e) {
            System.err.println("IOException!" + e.getMessage());
        }
    }

    public static List<String> readToList(String path) {
        List<String> message = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                message.add(line);
            }
        } catch (FileNotFoundException e) {
            System.err.println("No such file!");
        } catch (IOException e) {
            System.err.println("IOException!" + e.getMessage());
        }

        return message;
    }

    public static void main(String[] args) {
//        writeToFile("D:\\input.txt", "LALALLA");
//        updateFile("D:\\input.txt", "lllllaaalala UPDATE FFFFFF");
        List<String> l = readToList("abc.txt");
        for (String s : l) {
            System.out.println(s);
        }
    }
}
