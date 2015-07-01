package main.java.model;

/**
 * Created by robertdinu on 7/1/15.
 */
public class ListModel {

    // id will be used for primary key in MongoDB
    // We could use ObjectId, but I am keeping it
    // independent of MongoDB API classes
    private String id;

    private String title;

    private String description;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
