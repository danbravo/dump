package Lesson10Dz;

public class American extends Human{

    public American(String name) {
        super(name);
    }

    @Override
    public void sayHello() {
        System.out.println("Hi, my name is "+this.name);
    }
}
