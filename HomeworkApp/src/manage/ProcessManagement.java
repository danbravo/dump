package manage;

import core.*;
import exceptions.InvalidNameException;
import exceptions.InvalidPhoneNumberException;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProcessManagement {
    private GroupsManage groupsManage = new GroupsManage();
    private StudentManage studentManage = new StudentManage();
    private TutorManage tutorManage = new TutorManage();

    private Scanner intScanner = new Scanner(System.in);
    private Scanner strScanner = new Scanner(System.in);

    static {
        System.out.println("Tip: First create a database of students(1), tutors(2) and groups(3)\n" +
                "After that use Study process management menu(4) for operations\n");
    }

    private void studDbManagement() {
        System.out.println("\tEnter menu ID to proceed: ");
        System.out.println("1. Add a student");
        System.out.println("2. Delete a student");
        System.out.println("3. Change student info");
        System.out.println("4. View all students info");
        System.out.println("5. View one students info");
        System.out.println("6. Return");

        int input1 = intScanner.nextInt();
        if (input1 == 1) {
            int studListSize = studentManage.size();
            System.out.println("Enter students info (name, surname, courseID, credit book number, address, phone number, studentID):");
            try {
                String name = strScanner.next();
                if (!checkName(name)) {
                    throw new InvalidNameException(name);
                }
                String surname = strScanner.next();
                if (!checkName(surname)) {
                    throw new InvalidNameException(surname);
                }
                int courseId = intScanner.nextInt();
                String creditBook = strScanner.next();
                String address = strScanner.next();
                String phone = strScanner.next();
                if (!checkPhone(phone)) {
                    throw new InvalidPhoneNumberException(phone);
                }
                int studId = intScanner.nextInt();
                studentManage.add(new Student(name, surname, courseId,
                        creditBook, address, phone, studId));
                System.out.println(studentManage.size()>studListSize ? "--New student added--" : "--Adding failed--");
            } catch (InvalidNameException eName) {
                System.err.println("Invalid name: "+eName.getInput());
            } catch (InvalidPhoneNumberException eNum) {
                System.err.println("Invalid phone number: "+eNum.getInput());
            } catch (InputMismatchException eMis) {
                System.err.println("Invalid input: "+eMis.getLocalizedMessage());
                System.err.println("Must be an integer value");
            }
        } else if (input1 == 2) {
            System.out.println("Enter ID of student to delete:");
            try {
                int idToDelete = intScanner.nextInt();
                studentManage.delete(idToDelete);
            } catch (InputMismatchException e) {
                System.err.println("Invalid input: "+e.getMessage());
                System.err.println("Must be an integer value");
            }
        } else if (input1 == 3) {
            System.out.println("Enter ID of student you want to change:");
            try {
                int studId = intScanner.nextInt();
                System.out.println("Enter new students info (name, surname, courseID, credit book number, address, phone number, student ID):");
                String name = strScanner.next();
                if (!checkName(name)) {
                    throw new InvalidNameException(name);
                }
                String surname = strScanner.next();
                if (!checkName(surname)) {
                    throw new InvalidNameException(surname);
                }
                int courseId = intScanner.nextInt();
                String creditBook = strScanner.next();
                String address = strScanner.next();
                String phone = strScanner.next();
                if (!checkPhone(phone)) {
                    throw new InvalidPhoneNumberException(phone);
                }
                int id = intScanner.nextInt();
                Student studNewData = new Student(name, surname, courseId, creditBook, address, phone, id);
                studentManage.change(studId, studNewData);
            } catch (InputMismatchException e1) {
                System.err.println("Invalid input: "+e1.getMessage());
                System.err.println("Must be an integer value");
            } catch (InvalidNameException e2) {
                System.err.println("Invalid name: "+e2.getInput());
            } catch (InvalidPhoneNumberException e3) {
                System.err.println("Invalid phone number: "+e3.getInput());
            }
        } else if (input1 == 4) {
            studentManage.viewAll();
        } else if (input1 == 5) {
            System.out.println("Enter ID of student you want to view:");
            try {
                studentManage.viewOne(intScanner.nextInt());
            } catch (InputMismatchException e) {
                System.err.println("Invalid input: "+e.getMessage());
                System.err.println("Must be an integer value");
            }
        } else if (input1 == 6) {
            return;
        } else {
            System.err.println("Invalid input");
        }
    }

    private void tutDbManagement() {
        System.out.println("\tEnter menu ID to proceed: ");
        System.out.println("1. Add a tutor");
        System.out.println("2. Delete a tutor");
        System.out.println("3. Change tutor info");
        System.out.println("4. View all tutors info");
        System.out.println("5. View one tutors info");
        System.out.println("6. Return");

        int input1 = intScanner.nextInt();
        if (input1 == 1) {
            int tutListSize = tutorManage.size();
            System.out.println("Enter tutor info (name, surname, tutor ID):");
            try {
                String name = strScanner.next();
                if (!checkName(name)) {
                    throw new InvalidNameException(name);
                }
                String surname = strScanner.next();
                if (!checkName(surname)) {
                    throw new InvalidNameException(surname);
                }
                int id = intScanner.nextInt();
                tutorManage.add(new Tutor(name, surname, id));
                System.out.println(tutorManage.size()>tutListSize ? "--New tutor added--" : "--Adding failed--");
            } catch (InvalidNameException eName) {
                System.err.println("Invalid name: "+eName.getInput());
            } catch (InputMismatchException e) {
                System.err.println("Invalid ID input: "+e.getMessage());
                System.err.println("Must be an integer value");
            }
        } else if (input1 == 2) {
            System.out.println("Enter ID of tutor to delete:");
            try {
                int tutToDelete = intScanner.nextInt();
                tutorManage.delete(tutToDelete);
            } catch (InputMismatchException ex) {
                System.err.println("Invalid ID input: "+ex.getMessage());
                System.err.println("Must be an integer value");
            }
        } else if (input1 == 3) {
            System.out.println("Enter ID of tutor you want to change:");
            try {
                int tutId = intScanner.nextInt();
                System.out.println("Enter new tutors info (name, surname, tutor ID):");
                String name = strScanner.next();
                if (!checkName(name)) {
                    throw new InvalidNameException(name);
                }
                String surname = strScanner.next();
                if (!checkName(surname)) {
                    throw new InvalidNameException(surname);
                }
                int id = intScanner.nextInt();
                Tutor newTutor = new Tutor(name, surname, id);
                tutorManage.change(tutId, newTutor);
            } catch (InvalidNameException e) {
                System.err.println("Invalid name: "+e.getInput());
            } catch (InputMismatchException ex) {
                System.err.println("Invalid ID input: "+ex.getMessage());
                System.err.println("Must be an integer value");
            }
        } else if (input1 == 4) {
            tutorManage.viewAll();
        } else if (input1 == 5) {
            System.out.println("Enter ID of tutor you want to view:");
            try {
                tutorManage.viewOne(intScanner.nextInt());
            } catch (InputMismatchException e) {
                System.err.println("Invalid ID input: "+e.getMessage());
                System.err.println("Must be an integer value");
            }
        } else if (input1 == 6) {
            return;
        } else {
            System.err.println("Invalid input");
        }
    }

    private void groupDbManagement() {
        System.out.println("\tEnter menu ID to proceed: ");
        System.out.println("1. Add a group");
        System.out.println("2. Delete a group");
        System.out.println("3. Change group info");
        System.out.println("4. View all groups info");
        System.out.println("5. View one groups info");
        System.out.println("6. Return");

        int input1 = intScanner.nextInt();
        if (input1 == 1) {
            try {
                int grListSize = groupsManage.size();
                System.out.println("Enter group ID:");
                int id = intScanner.nextInt();
                groupsManage.add(new Group(id));
                System.out.println(groupsManage.size()>grListSize ? "--New group added--" : "--Adding failed--");
            } catch (InputMismatchException e) {
                System.err.println("Invalid ID input: "+e.getMessage());
                System.err.println("Must be an integer value");
            }
        } else if (input1 == 2) {
            System.out.println("Enter ID of group to delete:");
            try {
                int grToDelete = intScanner.nextInt();
                groupsManage.delete(grToDelete);
            } catch (InputMismatchException ex) {
                System.err.println("Invalid ID of the group: "+ex.getMessage());
                System.err.println("Must be an integer value");
            }
        } else if (input1 == 3) {
            System.out.println("Enter ID of group you want to change:");
            try {
                int grId = intScanner.nextInt();
                System.out.println("Enter new groups ID:");
                int id = intScanner.nextInt();
                Group newGroup = new Group(id);
                groupsManage.change(grId, newGroup);
            } catch (InputMismatchException ex) {
                System.err.println("Invalid ID input: "+ex.getMessage());
                System.err.println("Must be an integer value");
            }
        } else if (input1 == 4) {
            groupsManage.viewAll();
        } else if (input1 == 5) {
            System.out.println("Enter ID of group you want to view:");
            try {
                groupsManage.viewOne(intScanner.nextInt());
            } catch (InputMismatchException e) {
                System.err.println("Invalid ID input: "+e.getMessage());
                System.err.println("Must be an integer value");
            }
        } else if (input1 == 6) {
            return;
        } else {
            System.err.println("Invalid input");
        }
    }

    private void studyManagement() {
        System.out.println("\tEnter menu ID to proceed: ");
        System.out.println("1. Add subject to the group");
        System.out.println("2. Delete subject from the group");
        System.out.println("3. Change the tutor of the subject");
        System.out.println("4. Add a student to the group");
        System.out.println("5. Delete a student from the group");
        System.out.println("6. Return");

        int input1 = intScanner.nextInt();
        if (input1 == 1) {
            if (groupsManage.groupList.size()==0) {
                System.err.println("First create the DBs (students, tutors, groups)");
                return;
            }
            System.out.println("Enter group ID:");
            int groupID = intScanner.nextInt();
            System.out.println("Enter new subject name:");
            Subject newSubject = new Subject(strScanner.next());
            System.out.println("Enter ID of a tutor for this subject:");
            int tutorID = intScanner.nextInt();
            boolean found = true;
            for (Tutor t : tutorManage.tutorList) {
                if (t.getTutorId()==tutorID) {
                    groupsManage.addSubjectAndTutorToGroup(groupID, newSubject, t);
                    found = false;
                }
            }
            if (found) {
                System.err.println("Tutor with ID '"+tutorID+"' was not found\nPlease add the tutor to DB first");
            }
        } else if (input1 == 2) {
            if (groupsManage.groupList.size()==0) {
                System.err.println("First create the DBs (students, tutors, groups)");
                return;
            }
            System.out.println("Enter group ID:");
            int groupID = intScanner.nextInt();
            System.out.println("Enter subject name to delete:");
            Subject delSubject = new Subject(strScanner.next());
            groupsManage.deleteSubjectWithTutorFromGroup(groupID, delSubject);
        } else if (input1 == 3) {
            if (groupsManage.groupList.size()==0) {
                System.err.println("First create the DBs (students, tutors, groups)");
                return;
            }
            System.out.println("Enter group ID:");
            int groupID = intScanner.nextInt();
            System.out.println("Enter subject name:");
            Subject sub = new Subject(strScanner.next());
            System.out.println("Enter ID of a tutor for substitution:");
            int newTutorID = intScanner.nextInt();
            boolean found = true;
            for (Tutor t : tutorManage.tutorList) {
                if (t.getTutorId()==newTutorID) {
                    groupsManage.changeSubjectsTutorInAGroup(groupID, sub, t);
                    found = false;
                }
            }
            if (found) {
                System.err.println("Tutor with ID '"+newTutorID+"' was not found\nPlease add the tutor to DB first");
            }
        } else if (input1 == 4) {
            if (groupsManage.groupList.size()==0) {
                System.err.println("First create the DBs (students, tutors, groups)");
                return;
            }
            System.out.println("Enter group ID for a student:");
            int groupId = intScanner.nextInt();
            System.out.println("Enter student ID:");
            int studId = intScanner.nextInt();
            boolean found = true;
            for (Student s : studentManage.studList) {
                if (s.getStudId()==studId) {
                    groupsManage.addStudentToTheGroup(groupId, s);
                    found = false;
                }
            }
            if (found) {
                System.err.println("Student with ID '"+studId+"' was not found\nPlease add the student to DB first");
            }
        } else if (input1 == 5) {
            if (groupsManage.groupList.size()==0) {
                System.err.println("First create the DBs (students, tutors, groups)");
                return;
            }
            System.out.println("Enter group ID of a student:");
            int groupId = intScanner.nextInt();
            System.out.println("Enter student ID:");
            int studId = intScanner.nextInt();
            boolean found = true;
            for (Student s : studentManage.studList) {
                if (s.getStudId()==studId) {
                    groupsManage.delStudentFromTheGroup(groupId, s);
                    found = false;
                }
            }
            if (found) {
                System.err.println("Student with ID '"+studId+"' was not found\nPlease add the student to DB first");
            }
        } else if (input1 == 6) {
            return;
        } else {
            System.err.println("Invalid input");
        }
    }

    private void search() {
        System.out.println("\tEnter menu ID to proceed: ");
        System.out.println("1. Find a student from the DB by name and surname");
        System.out.println("2. Find a student from the group by name and surname");
        System.out.println("3. Find students by their tutor");
        System.out.println("4. Find students by subject");
        System.out.println("5. Return");

        int input1 = intScanner.nextInt();
        if (input1 == 1) {
            System.out.println("Enter name and surname of a student:");
            String name = strScanner.next();
            String surname = strScanner.next();

            boolean b = true;
            for (Student s : studentManage.studList) {
                if (s.getName().equalsIgnoreCase(name) &&
                        s.getSurname().equalsIgnoreCase(surname)) {
                    System.out.println(s.toString());
                    b = false;
                }
            }
            if(b) {
                System.err.println("No such student in the DB:");
                System.err.println(name + "\t" + surname);
            }
        } else if (input1 == 2) {
            System.out.println("Enter group ID:");
            int groupId = intScanner.nextInt();
            System.out.println("Enter name and surname of a student:");
            String name = strScanner.next();
            String surname = strScanner.next();

            byte i=0;
            byte k=0;
            for (Group g : groupsManage.groupList) {
                if (g.getGroupID()==groupId) {
                    i=1;
                    for (Student s : g.getStudents()) {
                        if (s.getName().equalsIgnoreCase(name) &&
                                s.getSurname().equalsIgnoreCase(surname)) {
                            k=1;
                            System.out.println(s.toString());
                        }
                    }
                }
            }
            System.err.println(i==0 ? "Group with ID "+groupId+" is not in the DB" :
                    (k==0 ? "Student '"+name+" "+surname+"' is not present in any group" : ""));
        } else if (input1 == 3) {
            System.out.println("Enter the tutor name of the students: ");
            String tutName = strScanner.next();
            byte i=0;
            for (Group g : groupsManage.groupList) {
                for (Subject s : g.getSubjects()) {
                    if (s.getSubjectTutor().getName().equalsIgnoreCase(tutName)) {
                        i=1;
                        g.getStudents().forEach(System.out::println);
                    }
                }
            }
            System.err.println(i==0 ? "No such tutor" : "");
        } else if (input1 == 4) {
            System.out.println("Enter the subject name:");
            String subject = strScanner.next();
            byte i=0;
            for (Group g : groupsManage.groupList) {
                for (Subject s : g.getSubjects()) {
                    if (s.getSubjectName().equalsIgnoreCase(subject)) {
                        i=1;
                        g.getStudents().forEach(System.out::println);
                    }
                }
            }
            System.err.println(i==0 ? "No such subject" : "");
        } else if (input1 == 5) {
            return;
        } else {
            System.err.println("Invalid input");
        }
    }

    public void management() {

        boolean working = true;
        while (working) {
            System.out.println("\tEnter menu ID to proceed: ");
            System.out.println("1. Student management");
            System.out.println("2. Tutor management");
            System.out.println("3. Group management");
            System.out.println("4. Study process management");
            System.out.println("5. Search");
            System.out.println("6. Save and Exit");

            int input = intScanner.nextInt();
            if (input==1) {
                studDbManagement();
            } else if (input==2) {
                tutDbManagement();
            } else if (input==3) {
                groupDbManagement();
            } else if (input==4) {
                studyManagement();
            } else if (input==5) {
                search();
            } else if(input==6) {
                writeToFile(studentManage.studList, studentManage.getFilePath());
                writeToFile(tutorManage.tutorList, tutorManage.getFilePath());
                writeToFile(groupsManage.groupList, groupsManage.getFilePath());
                for (Group g : groupsManage.groupList) {
                    writeToFile(g.getStudents(), g.getStudPath());
                    writeToFile(g.getSubjects(), g.getSubjPath());
                    writeToFile(g.getTutors(), g.getTutsPath());
                }
                working = false;
            } else {
                System.err.println("Invalid input: "+input);
            }
        }
    }

    private <T extends Being> void writeToFile(List<T> list, Path path) {
        try (OutputStream out = new BufferedOutputStream(
                Files.newOutputStream(path, StandardOpenOption.CREATE, StandardOpenOption.APPEND)
        )) {
            for (T s : list) {
                out.write(s.toString().getBytes());
                out.write("\n-------------------------------\n".getBytes());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean checkName(String name){
        Pattern p = Pattern.compile("^[a-zA-Z]{3,15}$");
        Matcher m = p.matcher(name);
        return m.matches();
    }

    private boolean checkPhone(String phone) {
        Pattern p = Pattern.compile("^[0-9]{7,15}$");
        Matcher m = p.matcher(phone);
        return m.matches();
    }
}
