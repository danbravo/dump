package APIs;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.fluent.Request;
import org.apache.http.entity.ContentType;
import org.apache.http.util.EntityUtils;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainApi {

    String host = "http://jsonplaceholder.typicode.com/";
    Gson gson = new Gson();

    @Test
    public void tryHttpWithApache() throws IOException {
        HttpResponse httpResponse = Request.Get(host+"posts").execute().returnResponse();
        int statusCode = httpResponse.getStatusLine().getStatusCode();
        HttpEntity entity = httpResponse.getEntity();
        String respJSON = EntityUtils.toString(entity);

//        System.out.println(statusCode);
        System.out.println(respJSON);

//        PostModel[] postModels = gson.fromJson(respJSON, PostModel[].class);
//        System.out.println(Arrays.toString(postModels));

        List<PostModel> postModelList = gson.fromJson(respJSON, new TypeToken<ArrayList<PostModel>>(){}.getType());
        postModelList.forEach(System.out::println);
    }

    @Test
    public void createNewPost() throws IOException {
        PostModel postModel = new PostModel();
        postModel.userId = 255;
        postModel.id = 666;
        postModel.title = "rarararar";
        postModel.body = "CHIN' CHIN' BLIN' BLIN' DOLLA DOLLA";

        String myJSON = gson.toJson(postModel);
        System.out.println(myJSON);

        HttpResponse httpResponse = Request.Post("http://jsonplaceholder.typicode.com/posts")
                .bodyString(myJSON, ContentType.APPLICATION_JSON).execute().returnResponse();

        HttpEntity entity = httpResponse.getEntity();
        String respJSON = EntityUtils.toString(entity);

        int statusCode = httpResponse.getStatusLine().getStatusCode();
        System.out.println(statusCode);
        System.out.println(respJSON);
        Assert.assertTrue(statusCode==201);
    }


    public List<CommentModel> getPostCommentsById(int postId) throws IOException {
        HttpResponse httpResponse = Request.Get(host+"posts/"+postId+"/comments").execute().returnResponse();
        HttpEntity entity = httpResponse.getEntity();
        String respJSON = EntityUtils.toString(entity);
        List<CommentModel> commentModels = gson.fromJson(respJSON, new TypeToken<ArrayList<CommentModel>>(){}.getType());
        return commentModels;
    }

    @Test
    public void testRequest() throws IOException {
        System.out.println(getPostCommentsById(3));
    }
}
