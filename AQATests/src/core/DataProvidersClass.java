package core;

import org.testng.annotations.DataProvider;
import pageObject.*;

public class DataProvidersClass {

    @DataProvider(name = "invalidEmails")
    public static Object[][] invalidEmails() {
        return new Object[][] {
                {"homenko.daniel@gmail.com"},
                {"plainaddress"},
                {"email.domain.com"},
                {"@domain.com"},
                {"#@%^%#$@#$@#.com"},
                {"Joe Smith <email@domain.com>"},
                {"email@domain.com (Joe Smith)"},
                {"email@domain@domain.com"},
                {".email@domain.com"},
                {"email.@domain.com"},
                {"email..email@domain.com"},
                {"あいうえお@domain.com"},
                {"email@-domain.com"},
                {"email@.domain.com"},
                {"email@111.222.333.44444"},
                {"email@domain..com"}
        };
    }

    @DataProvider(name = "regMails")
    public static Object[][] regMails() {
        return new Object[][] {
                {new RegMailRu()},
                {new RegGMail()}
        };
    }

    @DataProvider(name = "logInData")
    public static Object[][] logInData() {
        return new Object[][] {
                {new NewFbMainPage(), "dan.dudelife.bravo@gmail.com", "2342925bravo"},
                {new NewVkMainPage(), "mrbravo@bigmir.net", "2342925bravo"},
                {new NewSchoolMainPage(), "homenko.daniel@gmail.com", "2342925bravo"}
        };
    }
}
