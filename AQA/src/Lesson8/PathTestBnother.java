package Lesson8;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathTestBnother {
    public static void ifFileExists(String pathToFile) {
        Path path = Paths.get(pathToFile);

        if (Files.exists(path, LinkOption.NOFOLLOW_LINKS)) {
            System.out.println("The file/directory " + path.getFileName());

            if (Files.isDirectory(path, LinkOption.NOFOLLOW_LINKS)) {
                System.out.println(path.getFileName() + " is a directory");
            } else {
                System.out.println(path.getFileName() + " is a file");
            }
        } else {
            System.out.println("The file/directory " + path.getFileName() + " does not exists");
        }
    }

    public static void checkFile(String pathToFile) {
        Path path = Paths.get(pathToFile);

        System.out.format("Readable: %b, Writable: %b, Executable: %b\n",
                Files.isReadable(path), Files.isWritable(path), Files.isExecutable(path));
    }

    public static void getFileAttributes(String pathToFile) {
        Path path = Paths.get(pathToFile);
        try {
            Object object = Files.getAttribute(path, "creationTime");
            System.out.println("Creation time " + object);

            object = Files.getAttribute(path, "lastModifiedTime");
            System.out.println("Last modified time " + object);

            object = Files.getAttribute(path, "size");
            System.out.println("Size " + object);

            object = Files.getAttribute(path, "isDirectory");
            System.out.println("isDirectory " + object);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        Path path1 = Paths.get("abc.txt");
        Path path2 = Paths.get("D:\\projects\\AQA\\abc.txt");

        System.out.println(Files.isSameFile(path1, path2));

        ifFileExists(".\\abc.txt");
        checkFile("D:\\projects\\AQA\\abc.txt");
        getFileAttributes("D:\\projects\\AQA\\abc.txt");
    }
}
