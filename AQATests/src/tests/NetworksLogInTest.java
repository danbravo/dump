package tests;

import core.*;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({MyFileLogListener.class})
public class NetworksLogInTest extends BrowserFactory{

    @Test(dataProvider = "logInData", dataProviderClass = DataProvidersClass.class)
    public void tryLogIn(AbstractLogIn site, String email, String pass) {
        site.logIn(email, pass);
    }

//    @Test
//    public void test1() {
//        System.out.println("this is test 1");
//    }
//
//    @Test
//    public void test2() {
//        System.out.println("this is test 2");
//    }
//
//    @Test
//    public void test3() {
//        Assert.fail();
//        System.out.println("this is test 3");
//    }
//
//    @Test(dependsOnMethods = "test3")
//    public void test4() {
//        System.out.println("this is test 4");
//    }

}
