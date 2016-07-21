package Lesson11;

import Lesson10.BrowserFact;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DzTaskTwo extends BrowserFact{

    @Test()
    public void test1() {
        System.out.println("this is test 1");
    }

    @Test(dependsOnMethods = "test1")
    public void test2() {
        System.out.println("this is test 2");
    }

    @Test(dependsOnMethods = "test2")
    public void test3() {
        System.out.println("this is test 3");
    }

    @Test(dependsOnMethods = "test3")
    public void test4() {
        Assert.fail();
        System.out.println("this is test 4");
    }

    @Test(dependsOnMethods = "test3")
    public void test5() {
        System.out.println("this is test 5");
    }

    @Test(dependsOnMethods = "test4")
    public void test6() {
        System.out.println("this is test 6");
    }

    @Test(dependsOnMethods = "test6")
    public void test7() {
        System.out.println("this is test 7");
    }

    @Test(dependsOnMethods = {"test2", "test4", "test6"})
    public void test8() {
        System.out.println("this is test 8");
    }

    @Test(dependsOnMethods = "test8")
    public void test9() {
        System.out.println("this is test 9");
    }

    @Test(priority = 10, dependsOnMethods = {"test7", "test9"})
    public void test10() {
        System.out.println("this is test 10");
    }
}
