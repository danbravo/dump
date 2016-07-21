package APIs;

public class CommentModel {

    public int postId;
    public int id;
    public String name;
    public String email;
    public String body;

    @Override
    public String toString() {
        return "CommentModel: [" + "postId=" + postId + ", id=" + id +
                ", name='" + name + "', email='" + email + "', body='" + body + "']";
    }
}
