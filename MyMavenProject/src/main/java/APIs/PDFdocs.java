package APIs;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PDFdocs {
    private List<PDFdoc> items;
    private Integer total;
    @SerializedName("current_page")
    private Integer currentPage;
    @SerializedName("per_page")
    private Integer perPage;
    @SerializedName("prev_page_url")
    private String prevPageUrl;
    @SerializedName("next_page_url")
    private String nextPageUrl;

    @Override
    public String toString() {
        return "PDFdocs { " + "items=" + items + ", total=" + total + ", currentPage=" + currentPage + ", perPage=" + perPage +
                ", prevPageUrl='" + prevPageUrl + "', nextPageUrl='" + nextPageUrl + "' }";
    }

    public List<PDFdoc> getItems() {
        return items;
    }

    public Integer getTotal() {
        return total;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public Integer getPerPage() {
        return perPage;
    }

    public String getPrevPageUrl() {
        return prevPageUrl;
    }

    public String getNextPageUrl() {
        return nextPageUrl;
    }
}
