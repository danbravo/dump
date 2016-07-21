package tests.TestDir;

import org.testng.annotations.Factory;

public class TestFactory {

    @Factory
    public Object[] factoryMethod() {
        return new Object[] {
                new DependencyTest("first run"), new DependencyTest("second run")
        };
    }
}
