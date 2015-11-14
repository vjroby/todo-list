package ro.robertgabriel.frontend;

public class MenuItem {
    private String name;
    private String url;

    public String getName() {
        return name;
    }

    public MenuItem setName(String name) {
        this.name = name;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public MenuItem setUrl(String url) {
        this.url = url;
        return this;
    }
}
