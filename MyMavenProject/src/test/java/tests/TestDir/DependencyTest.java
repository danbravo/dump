package tests.TestDir;

import org.testng.annotations.Test;

public class DependencyTest {
    private String param;

    public DependencyTest(String param) {
        this.param = param;
    }

    @Test(dependsOnMethods = { "testMethodTwo" })
    public void testMethodOne() {
        System.out.println("Test method one with param values: " + this.param);
    }

    @Test
    public void testMethodTwo() {
        System.out.println("Test method two with param values: " + this.param);
    }
}
