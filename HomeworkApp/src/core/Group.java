package core;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Group extends Being {
    private int groupID;
    private List<Student> studentsList;
    private List<Subject> subjectsList;

    public Group(int id) {
        this.studentsList = new ArrayList<>();
        this.subjectsList = new ArrayList<>();
        this.groupID = id;
    }

    public int getGroupID() {
        return groupID;
    }

    public Path getStudPath() {
        return Paths.get("./files/groupsData/group"+getGroupID()+"Students.txt");
    }

    public Path getSubjPath() {
        return Paths.get("./files/groupsData/group"+getGroupID()+"Subjects.txt");
    }

    public Path getTutsPath() {
        return Paths.get("./files/groupsData/group"+getGroupID()+"Tutors.txt");
    }

    public List<Student> getStudents() {
        return studentsList;
    }

    public List<Subject> getSubjects() {
        return subjectsList;
    }

    public List<Tutor> getTutors() {
        List<Tutor> tutors = new ArrayList<>();
        for (Subject s : subjectsList) {
            tutors.add(s.getSubjectTutor());
        }
        return tutors;
    }

    public void addSubjectAndTutor(Subject sub, Tutor t) {
        for (Subject s : subjectsList) {
            if (s.getSubjectTutor().getTutorId()==t.getTutorId()) {
                System.err.println("Tutor '"+t.getName()+"' is already teaching one subject");
                return;
            }
        }
        if (findSubject(sub)) {
            System.err.println("Subject '"+sub.getSubjectName()+"' is already in the group");
        } else {
            sub.setSubjectTutor(t);
            subjectsList.add(sub);
            System.out.println("--Subject '"+sub.getSubjectName()+"' with tutor '"+t.getName()+"' was added to the group '"+this.getGroupID()+"'--");
        }
    }

    public void deleteSubjectWithTutor(Subject sub) {
        boolean b = true;
        for (Iterator<Subject> iterator = subjectsList.iterator(); iterator.hasNext();) {
            Subject subject = iterator.next();
            if (subject.getSubjectName().equalsIgnoreCase(sub.getSubjectName())) {
                iterator.remove();
                System.out.println("--Subject "+sub.getSubjectName()+" was removed from the group--");
                b = false;
            }
        }
        if (b) {
            System.err.println("No "+sub.getSubjectName()+" subject to delete");
        }
    }

    public void changeSubjectsTutor(Subject s, Tutor t) {
        for (Subject subj : subjectsList) {
            if (subj.getSubjectTutor().getTutorId()==t.getTutorId()) {
                System.err.println("Tutor '"+t.getName()+"' is already teaching one subject");
                return;
            }
        }
        boolean b = true;
        for (Iterator<Subject> iterator = subjectsList.iterator(); iterator.hasNext();) {
            Subject subject = iterator.next();
            if (subject.getSubjectName().equalsIgnoreCase(s.getSubjectName())) {
                subject.setSubjectTutor(t);
                System.out.println("--Subjects tutor was substituted by '"+t.getName()+"'--");
                b = false;
            }
        }
        if (b) {
            System.err.println("No '"+s.getSubjectName()+"' subject in the list");
        }
    }

    public void addStudent(Student stud) {
        if (findStud(stud.getStudId())) {
            System.err.println("Student is already in the group: "+stud.toString());
        } else {
            studentsList.add(stud);
            System.out.println("--Student '"+ stud.getName()+"' was added to group "+this.getGroupID()+"--");
        }
    }

    public void deleteStudent(Student stud) {
        boolean b = true;
        for (Iterator<Student> iterator = studentsList.iterator(); iterator.hasNext();) {
            Student st = iterator.next();
            if (st.getStudId()==stud.getStudId()) {
                iterator.remove();
                System.out.println("--Student '"+stud.getName()+"' with ID "+stud.getStudId()+" was removed from the group--");
                b = false;
            }
        }
        if (b) {
            System.err.println("No such student ID in the group: "+stud.getStudId());
        }
    }

    private boolean findStud(int id) {
        boolean result = false;
        for (Student stud : studentsList) {
            if (stud.getStudId()==id) {
                result = true;
            }
        }
        return result;
    }

    private boolean findSubject(Subject s) {
        boolean result = false;
        for (Subject sub : subjectsList) {
            if (sub.getSubjectName().equalsIgnoreCase(s.getSubjectName())) {
                result = true;
            }
        }
        return result;
    }

    @Override
    public String toString() {
        return "Group ID: " + groupID +
                "\nGroup size: " + studentsList.size() +
                "\nGroup tutors: " + subjectsList.size() +
                "\nGroup subjects: " + subjectsList.size();
    }
}
