package manage;

import core.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class GroupsManage extends AbstractManage<Group>{
    List<Group> groupList;
    private static int groupNum;
    private final Path filePath = Paths.get("./files/groupDB.txt");

    public GroupsManage() {
        this.groupList = new LinkedList<>();
        groupNum = 0;
    }

    public int size() {
        return groupNum;
    }

    public Path getFilePath() {
        return filePath;
    }

    private boolean findGroup(int id) {
        boolean result = false;
        for (Group g : groupList) {
            if (g.getGroupID()==id) {
                result = true;
            }
        }
        return result;
    }

    public void addSubjectAndTutorToGroup(int groupId, Subject s, Tutor t) {
        boolean b = true;
        for (Iterator<Group> iterator = groupList.iterator(); iterator.hasNext();) {
            Group g = iterator.next();
            if (g.getGroupID()==groupId) {
                g.addSubjectAndTutor(s, t);
                b = false;
            }
        }
        if (b) {
            System.err.println("No such group ID in the list: "+groupId);
        }
    }

    public void deleteSubjectWithTutorFromGroup(int groupId, Subject s) {
        boolean b = true;
        for (Iterator<Group> iterator = groupList.iterator(); iterator.hasNext();) {
            Group g = iterator.next();
            if (g.getGroupID()==groupId) {
                g.deleteSubjectWithTutor(s);
                b = false;
            }
        }
        if (b) {
            System.err.println("No such group ID in the list: "+groupId);
        }
    }

    public void changeSubjectsTutorInAGroup(int groupId, Subject s, Tutor newTut) {
        boolean b = true;
        for (Iterator<Group> iterator = groupList.iterator(); iterator.hasNext();) {
            Group g = iterator.next();
            if (g.getGroupID()==groupId) {
                g.changeSubjectsTutor(s, newTut);
                b = false;
            }
        }
        if (b) {
            System.err.println("No such group ID in the list: "+groupId);
        }
    }

    public void addStudentToTheGroup(int groupId, Student s) {
        for (Group gr : groupList) {
            for (Student st : gr.getStudents()) {
                if (st.getStudId()==s.getStudId()) {
                    System.err.println("Student with ID '"+s.getStudId()+"' is already in the group '"+gr.getGroupID()+"'");
                    return;
                }
            }
        }
        boolean b = true;
        for (Iterator<Group> iterator = groupList.iterator(); iterator.hasNext();) {
            Group g = iterator.next();
            if (g.getGroupID()==groupId) {
                g.addStudent(s);
                b = false;
            }
        }
        if (b) {
            System.err.println("No such group ID in the list: "+groupId);
        }
    }

    public void delStudentFromTheGroup(int groupId, Student s) {
        boolean b = true;
        for (Iterator<Group> iterator = groupList.iterator(); iterator.hasNext();) {
            Group g = iterator.next();
            if (g.getGroupID()==groupId) {
                g.deleteStudent(s);
                b = false;
            }
        }
        if (b) {
            System.err.println("No such group ID in the list: "+groupId);
        }
    }

    @Override
    public void add(Group b) {
        if (findGroup(b.getGroupID())) {
            System.err.println("Group with ID '"+b.getGroupID()+"' is already in the list");
        } else {
            groupList.add(b);
            groupNum++;
        }
    }

    @Override
    public void delete(int id) {
        boolean b = true;
        for (Iterator<Group> iterator = groupList.iterator(); iterator.hasNext();) {
            Group g = iterator.next();
            if (g.getGroupID()==id) {
                iterator.remove();
                groupNum--;
                System.out.println("--Group with ID "+id+" was deleted--");
                b = false;
            }
        }
        if (b) {
            System.err.println("No such group ID in the list: "+id);
        }
    }

    @Override
    public void change(int oldId, Group toUpdate) {
        for (Iterator<Group> iter = groupList.iterator(); iter.hasNext();) {
            Group gr = iter.next();
            if (gr.getGroupID()==toUpdate.getGroupID()) {
                System.err.println("Error. Group with ID '"+toUpdate.getGroupID()+"' is in the list");
                return;
            }
        }
        boolean b = true;
        for (Iterator<Group> iterator = groupList.iterator(); iterator.hasNext();) {
            Group g = iterator.next();
            if (g.getGroupID()==oldId) {
                groupList.remove(g);
                groupList.add(toUpdate);
                System.out.println("--Group with old ID "+oldId+" updated--");
                b = false;
            }
        }
        if (b) {
            System.err.println("No such group ID in the list: "+oldId);
        }
    }

    @Override
    public void viewAll() {
        if (groupList.isEmpty()) {
            System.err.println("Group list is empty");
        } else {
            for (Group g : groupList) {
                System.out.println(g.toString());
                System.out.println("====================================");
            }
        }
    }

    @Override
    public void viewOne(int groupId) {
        boolean b = true;
        for (Iterator<Group> iterator = groupList.iterator(); iterator.hasNext();) {
            Group g = iterator.next();
            if (g.getGroupID()==groupId) {
                System.out.println(g.toString());
                System.out.println("====================================");
                b = false;
            }
        }
        if (b) {
            System.err.println("No such group ID in the list: "+groupId);
        }
    }
}
