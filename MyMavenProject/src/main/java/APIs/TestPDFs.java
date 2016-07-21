package APIs;

import com.google.gson.Gson;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.fluent.Request;
import org.apache.http.entity.ContentType;
import org.apache.http.util.EntityUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class TestPDFs {

    Gson gson = new Gson();

    public PDFdocs getPdfDocs() throws IOException {
        HttpResponse httpResp = Request.Get("https://api.pdffiller.com/v1/document")
                .addHeader("Authorization", "Bearer nCi1Ymp5imCl3tbIGgx6E4ohV8IYAfgVlfC1pbFU")
                .execute().returnResponse();
        HttpEntity entity = httpResp.getEntity();
        String JSONresp = EntityUtils.toString(entity);

        PDFdocs pdfDocs = gson.fromJson(JSONresp, PDFdocs.class);
        return pdfDocs;
    }

    @Test
    public void tryGetDocs() throws IOException {
        System.out.println(getPdfDocs());
        getPdfDocs().getItems().forEach(System.out::println);
    }

    public String createDoc() throws IOException {
        PDFdocCreate newDoc = new PDFdocCreate();
        newDoc.setFile("http://downloads.palass.org/annual_meeting/2000/confabs2000.pdf");
        String myJSON = gson.toJson(newDoc);

        HttpResponse httpResponse = Request.Post("https://api.pdffiller.com/v1/document")
                .addHeader("Authorization", "Bearer nCi1Ymp5imCl3tbIGgx6E4ohV8IYAfgVlfC1pbFU")
                .bodyString(myJSON, ContentType.APPLICATION_JSON)
                .execute().returnResponse();
        HttpEntity entity = httpResponse.getEntity();
        String JSONresponse = EntityUtils.toString(entity);

        int statusCode = httpResponse.getStatusLine().getStatusCode();
        Assert.assertTrue(statusCode == 200);
        return JSONresponse;
    }

    @Test
    public void tryCreateDoc() throws IOException {
        System.out.println(createDoc());
    }

    public String deleteDoc(Integer docId) throws IOException {
        HttpResponse httpResponse = Request.Delete("https://api.pdffiller.com/v1/document/"+docId)
                .addHeader("Authorization", "Bearer nCi1Ymp5imCl3tbIGgx6E4ohV8IYAfgVlfC1pbFU")
                .execute().returnResponse();
        HttpEntity entity = httpResponse.getEntity();
        String JSONresponse = EntityUtils.toString(entity);

        int statusCode = httpResponse.getStatusLine().getStatusCode();
        Assert.assertTrue(statusCode == 200);
        return JSONresponse;
    }

    @Test
    public void tryDeleteDoc() throws IOException {
        String deleteMessage = deleteDoc(70789830);
        PDFdocDelete JSONdelete = gson.fromJson(deleteMessage, PDFdocDelete.class);
        System.out.println(JSONdelete.getMessage());
    }
}
