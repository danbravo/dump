package Lesson8;

import java.io.*;

public class FileIOTest {

    public static void writeToFile() throws IOException{
        String firstline = "LEXA LOX";
        String secondLine = "objelsa blox";

        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("D:\\input.txt")));

        writer.append(firstline);
        writer.newLine();
        writer.append(secondLine);
        writer.close();
    }

    public static void readFile() throws IOException {
        BufferedReader reader = new BufferedReader(
                new FileReader("D:\\input.txt"));
        String line;

        while((line = reader.readLine()) != null) {
            System.out.println(line);
        }
        reader.close();
    }

    public static void updateFile(String filePath, String toUpdate) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));

        String text;
        StringBuilder tempText = new StringBuilder();
        while((text = reader.readLine()) != null) {
            tempText.append(text);
        }
        reader.close();

        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filePath)));
        writer.append(tempText);
        writer.newLine();
        writer.append(toUpdate);
        writer.close();
    }

    public static void main(String[] args) throws IOException {
        updateFile("D:\\input.txt", "UPDATE BITCH");
    }
}
