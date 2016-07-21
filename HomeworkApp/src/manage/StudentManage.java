package manage;

import core.Student;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StudentManage extends AbstractManage<Student>{
    List<Student> studList;
    private static int studNum;
    private final Path filePath = Paths.get("./files/studentDB.txt");

    public StudentManage() {
        studList = new ArrayList<>();
        studNum = 0;
    }

    public int size() {
        return studNum;
    }

    public Path getFilePath() {
        return filePath;
    }

    private boolean findStudent(int id) {
        boolean result = false;
        for (Student stud : studList) {
            if (stud.getStudId()==id) {
                result = true;
            }
        }
        return result;
    }

    @Override
    public void add(Student s) {
        if (findStudent(s.getStudId())) {
            System.err.println("Student with ID '"+s.getStudId()+"' already in the list");
        } else {
            studList.add(s);
            studNum++;
        }
    }

    @Override
    public void delete(int id) {
        boolean b = true;
        for (Iterator<Student> iterator = studList.iterator(); iterator.hasNext();) {
            Student st = iterator.next();
            if (st.getStudId()==id) {
                iterator.remove();
                studNum--;
                System.out.println("--Student with ID "+id+" was deleted--");
                b = false;
            }
        }
        if (b) {
            System.err.println("No such student ID in the list: "+id);
        }
    }

    @Override
    public void change(int oldId, Student toUpdate) {
        for (Iterator<Student> iter = studList.iterator(); iter.hasNext();) {
            Student s = iter.next();
            if (s.getStudId()==toUpdate.getStudId()) {
                System.err.println("Error. Student with ID '"+toUpdate.getStudId()+"' is in the list");
                return;
            }
        }
        boolean b = true;
        for (Iterator<Student> iterator = studList.iterator(); iterator.hasNext();) {
            Student st = iterator.next();
            if (st.getStudId()==oldId) {
                studList.remove(st);
                studList.add(toUpdate);
                System.out.println("--Student with old ID "+oldId+" updated--");
                b = false;
            }
        }
        if (b) {
            System.err.println("No such student ID in the list: "+oldId);
        }
    }


    @Override
    public void viewAll() {
        if (studList.isEmpty()) {
            System.err.println("Student list is empty");
        } else {
            for (Student s : studList) {
                System.out.println(s.toString());
                System.out.println("====================================");
            }
        }
    }

    @Override
    public void viewOne(int studId) {
        boolean b = true;
        for (Iterator<Student> iterator = studList.iterator(); iterator.hasNext();) {
            Student st = iterator.next();
            if (st.getStudId()==studId) {
                System.out.println(st.toString());
                System.out.println("====================================");
                b = false;
            }
        }
        if (b) {
            System.err.println("No such student ID in the list: "+studId);
        }
    }
}
