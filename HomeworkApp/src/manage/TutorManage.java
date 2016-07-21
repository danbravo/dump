package manage;

import core.Tutor;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TutorManage extends AbstractManage<Tutor>{
    List<Tutor> tutorList;
    private static int tutorNum;
    private final Path filePath = Paths.get("./files/tutorDB.txt");


    public TutorManage() {
        tutorList = new ArrayList<>();
        tutorNum = 0;
    }

    public int size() {
        return tutorNum;
    }

    public Path getFilePath() {
        return filePath;
    }

    boolean findTutor(int id) {
        boolean result = false;
        for (Tutor g : tutorList) {
            if (g.getTutorId()==id) {
                result = true;
            }
        }
        return result;
    }

    @Override
    public void add(Tutor t) {
        if (findTutor(t.getTutorId())) {
            System.err.println("Tutor with ID '"+t.getTutorId()+"' is already in the list");
        } else {
            tutorList.add(t);
            tutorNum++;
        }
    }

    @Override
    public void delete(int id) {
        boolean b = true;
        for (Iterator<Tutor> iterator = tutorList.iterator(); iterator.hasNext();) {
            Tutor t = iterator.next();
            if (t.getTutorId()==id) {
                iterator.remove();
                tutorNum--;
                System.out.println("--Tutor with ID "+id+" was deleted--");
                b = false;
            }
        }
        if (b) {
            System.err.println("No such tutor ID in the list: "+id);
        }
    }

    @Override
    public void change(int oldId, Tutor toUpdate) {
        for (Iterator<Tutor> iter = tutorList.iterator(); iter.hasNext();) {
            Tutor tut = iter.next();
            if (tut.getTutorId()==toUpdate.getTutorId()) {
                System.err.println("Error. Tutor with ID '"+toUpdate.getTutorId()+"' is in the list");
                return;
            }
        }
        boolean b = true;
        for (Iterator<Tutor> iterator = tutorList.iterator(); iterator.hasNext();) {
            Tutor t = iterator.next();
            if (t.getTutorId()==oldId) {
                tutorList.remove(t);
                tutorList.add(toUpdate);
                System.out.println("--Tutor with old ID "+oldId+" updated--");
                b = false;
            }
        }
        if (b) {
            System.err.println("No such tutor ID in the list: "+oldId);
        }
    }

    @Override
    public void viewAll() {
        if (tutorList.isEmpty()) {
            System.err.println("Tutor list is empty");
        } else {
            for (Tutor t : tutorList) {
                System.out.println(t.toString());
                System.out.println("====================================");
            }
        }
    }

    @Override
    public void viewOne(int tutorId) {
        boolean b = true;
        for (Iterator<Tutor> iterator = tutorList.iterator(); iterator.hasNext();) {
            Tutor t = iterator.next();
            if (t.getTutorId()==tutorId) {
                System.out.println(t.toString());
                System.out.println("====================================");
                b = false;
            }
        }
        if (b) {
            System.err.println("No such tutor ID in the list: "+tutorId);
        }
    }
}
