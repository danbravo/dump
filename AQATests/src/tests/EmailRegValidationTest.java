package tests;

import core.AbstractReg;
import core.BrowserFactory;
import core.DataProvidersClass;
import org.testng.annotations.Test;

public class EmailRegValidationTest extends BrowserFactory{

    @Test(dataProvider = "regMails", dataProviderClass = DataProvidersClass.class)
    public void tryEmailReg(AbstractReg mailService) {
        mailService.reg("Rasta", "Gangsta", "asdsssRdWWdd123", "2342925bravo",
                18, 4, 1991, "male");

    }
}
