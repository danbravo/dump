package tests.TestDir;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

public class FTest {
    private String param;

    @Factory(dataProvider = "dataMethod")
    public FTest(String p) {
        this.param = p;
    }

    @DataProvider
    public static Object[][] dataMethod() {
        return new Object[][] {
                {"some data"},
                {"some more data"}
        };
    }

    @Test
    public void simpleTest1() {
        System.out.println("1st Simple test method");
        System.out.println(param);
    }

    @Test
    public void simpleTest2() {
        System.out.println("2st Simple test method");
        System.out.println(param);
    }
}
