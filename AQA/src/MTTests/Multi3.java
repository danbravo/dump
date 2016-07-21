package MTTests;

public class Multi3 implements Runnable{
    @Override
    public void run() {
        System.out.println("thread is running...");
    }

    public static void main(String[] args) {
        Multi3 m3 = new Multi3();
        Thread t3 = new Thread(m3);
        t3.start();
    }
}
