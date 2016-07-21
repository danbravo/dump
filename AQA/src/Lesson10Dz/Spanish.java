package Lesson10Dz;

public class Spanish extends Human{

    public Spanish(String name) {
        super(name);
    }

    @Override
    public void sayHello() {
        System.out.println("Holla! Me llamo "+this.name);
    }
}
