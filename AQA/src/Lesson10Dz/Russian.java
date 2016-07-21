package Lesson10Dz;

public class Russian extends Human {

    public Russian(String name) {
        super(name);
    }

    @Override
    public void sayHello() {
        System.out.println("Zdarova! Men9 zovut "+this.name);
    }
}
