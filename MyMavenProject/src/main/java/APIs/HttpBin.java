package APIs;

import com.google.gson.Gson;
import org.apache.http.client.fluent.Executor;
import org.apache.http.client.fluent.Request;
import org.testng.annotations.Test;
import java.io.IOException;

public class HttpBin {

    private String url = "http://httpbin.org/";
    Gson gson = new Gson();

    public void tryBasicAuth(String name, String pass) throws IOException {
        Executor executor = Executor.newInstance().auth(name, pass);
        String JSONresp = executor.execute(Request.Get(url + "basic-auth/" + name + "/" + pass))
                .handleResponse(httpResponse -> httpResponse.getStatusLine().getStatusCode() == 200 ? "Auth success" : "Auth failure");
        System.out.println(JSONresp);
    }

    @Test
    public void tryAuth() throws IOException {
        tryBasicAuth("dan", "passAss");
    }
}
