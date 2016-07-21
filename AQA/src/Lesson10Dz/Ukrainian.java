package Lesson10Dz;

public class Ukrainian extends Human{

    public Ukrainian(String name) {
        super(name);
    }

    @Override
    public void sayHello() {
        System.out.println("Dobrui den'! Mene zvut' "+this.name);
    }
}
