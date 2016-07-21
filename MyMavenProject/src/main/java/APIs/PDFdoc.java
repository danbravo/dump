package APIs;

public class PDFdoc {
    private Integer id;
    private String name;
    private String type;
    private Integer created;

    @Override
    public String toString() {
        return "PDFdoc { " + "id=" + id + ", name='" + name + "', type='" + type + "', created=" + created + " }";
    }
}
