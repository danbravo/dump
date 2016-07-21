package Lesson8;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileClassTest {
    public static void main(String[] args) {
        String currentDir = System.getProperty("user.dir");
        String linuxStyle = "dir/somefile.txt";
        String windowsStyle = "\\somefile.txt";

//        File file = new File(currentDir, linuxStyle);
//        System.out.println(file.getAbsolutePath());
        try {
            File file = new File(currentDir, windowsStyle);
            System.out.println(file.getAbsolutePath());
            if (file.createNewFile()) {
                System.out.println("File is created!");
            } else {
                System.out.println("File is not created!");
            }
        } catch (IOException e) {
            System.err.println("IOException: "+e.getMessage());
        }
    }
}
