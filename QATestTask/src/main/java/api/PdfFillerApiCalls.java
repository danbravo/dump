package api;

import io.restassured.path.json.JsonPath;
import ru.yandex.qatools.allure.annotations.Step;
import java.util.List;
import static io.restassured.RestAssured.given;

public class PdfFillerApiCalls {
    private final String userToken = "nCi1Ymp5imCl3tbIGgx6E4ohV8IYAfgVlfC1pbFU";
    private final String url = "https://api.pdffiller.com";

    @Step("Getting a list of documents")
    public List<Integer> getDocuments() {
        String responseJson =
                given().log().all().
                        contentType("application/json").
                when().auth().oauth2(userToken).
                        get(url+"/v1/document").
                then().
                        statusCode(200).
                        extract().response().getBody().asString();

        JsonPath jsonPath = new JsonPath(responseJson).setRoot("items");
        return jsonPath.getList("id");
    }

    @Step("Creating a new document")
    public int createDocument(String filePath) {
        String responseJson =
        given().log().all().contentType("application/json").
                body(filePath).
        when().auth().oauth2(userToken).
                post(url+"/v1/document").
        then().
                statusCode(200).extract().response().getBody().asString();

        JsonPath jsonPath = new JsonPath(responseJson);
        return jsonPath.getInt("id");
    }

    @Step("Deleting a document")
    public void deleteDocument(long docId) {
        given().log().all().
                contentType("application/json").
        when().auth().oauth2(userToken).
                delete(url+"/v1/document/{documentId}", docId).
        then().
                statusCode(200).extract().response().getBody().asString();
    }

}
