package main.java.model;

import java.util.List;

public class ListModel {

    // id will be used for primary key in MongoDB
    // We could use ObjectId, but I am keeping it
    // independent of MongoDB API classes
    private String id;

    private String title;

    private String description;

    private List<ItemModel> items;

    ;
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

    public List<ItemModel> getItems() {
        return items;
    }

    public void setItems(List<ItemModel> items) {
        this.items = items;
    }
}
