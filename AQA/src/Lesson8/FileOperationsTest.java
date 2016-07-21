package Lesson8;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class FileOperationsTest {

    public static void copyFile(String pathToFile) {
        Path pathSource = Paths.get(pathToFile);
        Path pathDestination = Paths.get(pathToFile.replace(".txt", "(copy).txt"));

        try {
            //for replacing the previously copied file add StandardCopyOption.REPLACE_EXISTING
            Files.copy(pathSource, pathDestination);
            System.out.println("Source file copied successfully");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void moveFile(String pathToFile, String newFileDestination) {
        Path pathSource = Paths.get(pathToFile);
        Path pathDestination = Paths.get(newFileDestination);

        try {
            Files.move(pathSource, pathDestination, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Source file successfully moved to new destination");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void deleteFile(String pathToFile) {
        Path pathSource = Paths.get(pathToFile);

        try {
            Files.delete(pathSource);
            System.out.println("File deleted successfully");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        deleteFile(".\\b.txt");
    }
}
