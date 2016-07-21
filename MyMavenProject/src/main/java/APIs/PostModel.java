package APIs;

import com.google.gson.annotations.SerializedName;

public class PostModel {

    //    @SerializedName("userId") if JSON param has a bad name
    public int userId;
    public int id;
    public String title;
    public String body;

    @Override
    public String toString() {
        return "PostModel [userId=" + userId + ", id=" + id +
                ", title='" + title + ", body='" + body + ']';
    }
}
