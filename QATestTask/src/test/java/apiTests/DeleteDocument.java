package apiTests;

import core.BrowserFact;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import java.util.ArrayList;
import java.util.List;

@Features({"DELETE API request"})
@Stories({"Getting docs (API call), deleting one (API call), than check if deleted doc is absent (API call)"})
public class DeleteDocument extends BrowserFact {
    private int docToDelete;
    private List<Integer> newDocIds = new ArrayList<>();

    @Test(priority = 0)
    public void getDocs() {
        List<Integer> DocIds = apiCalls.getDocuments();
        docToDelete = DocIds.get(0);
    }

    @Test(priority = 1)
    public void deleteDocument() {
        apiCalls.deleteDocument(docToDelete);
    }

    @Test(priority = 2)
    public void getNewDocs() {
        newDocIds = apiCalls.getDocuments();
    }

    @Test(priority = 3)
    public void verifyDeletedDoc() {
        Assert.assertFalse(newDocIds.contains(docToDelete));
    }
}
