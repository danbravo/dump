package core;

public class Tutor extends Being {
    private String name;
    private String surname;
    private final int tutorId;

    public Tutor(final String name, final String surname, final int id) {
        this.name = name;
        this.surname = surname;
        this.tutorId = id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getTutorId() {
        return tutorId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public String toString() {
        return "Name: " + name +
                "\nSurname: " + surname +
                "\nTutor ID: " + tutorId;
    }
}
