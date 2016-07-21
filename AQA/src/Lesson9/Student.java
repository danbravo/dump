package Lesson9;

public class Student extends Person{
    private String university;
    private String response;
    private String group;

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public Student(String name, String university) {
        super(name);
        this.university = university;
    }

    public String getResponse(String question) {
        response = question + ", yes, I know, but forgot";
        if ((question != null) && (!question.equals(""))) {
            return response;
        } else {
            return "Ehhh, what was the q?";
        }
    }
}
