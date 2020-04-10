package libertySearch.pojo;

public class Engine {
    private String name;
    private String url;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String readKeyword(String keyword) {
        return String.format(this.url, keyword);
    }
}
