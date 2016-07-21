package core;

public class Student extends Being {
    private String name;
    private String surname;
    private int course;
    private String creditBookNumber;
    private String address;
    private String phoneNumber;
    private final int studId;

    public Student(final String name, final String surname, final int course,
                   final String creditBookNumber, final String address, final String phoneNumber, final int id) {
        this.name = name;
        this.surname = surname;
        this.course = course;
        this.creditBookNumber = creditBookNumber;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.studId = id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getCourse() {
        return course;
    }

    public String getCreditBookNumber() {
        return creditBookNumber;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getStudId() {
        return studId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public void setCreditBookNumber(String creditBookNumber) {
        this.creditBookNumber = creditBookNumber;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Name: " + name +
                "\nSurname: " + surname +
                "\nCourse: " + course +
                "\nCredit book number: " + creditBookNumber +
                "\nAddress: " + address +
                "\nPhone Number: " + phoneNumber +
                "\nStudent ID: " + studId;
    }
}
