package Lesson8;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class PipedIOTest {
    public static void main(String[] args) throws IOException {
        final PipedOutputStream pout = new PipedOutputStream();
        final PipedInputStream pin = new PipedInputStream();

        pout.connect(pin);//connecting the streams

        //creating one thread t1 which writes the data
        Thread t1 = new Thread() {
            public void run() {
                for (int i=65; i<90; i++) {
                    try {
                        pout.write(i);
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        System.err.println("Interrupted Exception: "+e.getMessage());
                    } catch (IOException e1) {
                        System.err.println("IOException: "+e1.getMessage());
                    }
                }
            }
        };
        //creating another thread t2 which reads the data
        Thread t2 = new Thread() {
            public void run() {
                try {
                    for (int i=65; i<90; i++) {
                        System.out.println(pin.read());
                    }
                } catch (IOException e) {
                    System.err.println("IOException: "+e.getMessage());
                }
            }
        };
        //starting both threads
        t1.start();
        t2.start();
    }
}
