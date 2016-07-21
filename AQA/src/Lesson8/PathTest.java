package Lesson8;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PathTest {
    public static void main(String[] args) {
        Path filePath = Paths.get("D:\\projects\\AQA\\src\\abc.txt");
        System.out.println("\tFile name: " + filePath.getFileName());
        System.out.println("\tRoot of the path: " + filePath.getRoot());
        System.out.println("\tParent of the target: " + filePath.getParent());

        System.out.println("Printing elements of the path: ");
        for (Path element : filePath) {
            System.out.println("\tpath element " + element);
        }
    }
}
