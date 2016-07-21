package Lesson11;

import Lesson10.BrowserFact;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DzTaskThree extends BrowserFact{

    @Parameters({"firstName"})
    @Test
    public void test1(@Optional("Dan") String name) {
        System.out.println("This is test 1");
        System.out.println("Name is " + name);
    }

    @Test
    public void test2() {
        System.out.println("This is test 2");
    }

    @Test
    public void test3() {
        System.out.println("This is test 3");
    }

    @Test
    public void test4() {
        System.out.println("This is test 4");
    }

    @Test
    public void test5() {
        System.out.println("This is test 5");
    }


}
