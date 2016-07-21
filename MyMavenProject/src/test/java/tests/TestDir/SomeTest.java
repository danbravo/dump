package tests.TestDir;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SomeTest {

    @Parameters({"message"})
    @Test(groups = {"functional"})
    public void test1(@Optional("optional annotation") String msg) {
        System.out.println("Test 1 is done");
        System.out.println("This parameter is from " + msg);
    }

    @Parameters({"message"})
    @Test(groups = {"functional", "integration"})
    public void test2(@Optional("optional annotation") String msg) {
        System.out.println("Test 2 is done");
        System.out.println("This parameter is from " + msg);
    }

    @Parameters({"text"})
    @Test(groups = {"integration"})
    public void anotherTest(String text) {
        System.out.println("Another Test is done");
        System.out.println("This param is: " + text);
    }
}
