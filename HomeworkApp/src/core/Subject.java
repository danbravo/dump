package core;

public class Subject extends Being{
    private String subjectName;
    private Tutor subjectTutor;

    public Subject(final String name) {
        this.subjectName = name;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public Tutor getSubjectTutor() {
        return subjectTutor;
    }

    public void setSubjectTutor(Tutor subjectTutor) {
        this.subjectTutor = subjectTutor;
    }

    @Override
    public String toString() {
        return "Subject Name: " + subjectName +
                "\nSubject Tutor: " + subjectTutor;
    }
}
