package pages;

import core.MethodsFact;
import org.openqa.selenium.By;
import ru.yandex.qatools.allure.annotations.Step;

public class FormsPage extends MethodsFact{
    private By allDocsMenu = By.xpath("//*[@id='fnamemy_docs']");
    private By documentItems = By.xpath("//tr[@data-type='pdf']");

    @Step("Pressing the 'All documents' menu button")
    public void clickAllDocsMenuBtn() {
        click(allDocsMenu);
    }

    @Step("Getting size of documents list")
    public int getAllDocsSize() {
        return driver.findElements(documentItems).size();
    }

    @Step("Checking that document is created")
    public boolean verifyDocCreation(int docId) {
        return driver.findElements(By.xpath("//*[@id='name"+docId+"']")).size() > 0;
    }

}
