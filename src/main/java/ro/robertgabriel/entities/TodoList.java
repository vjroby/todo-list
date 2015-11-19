package ro.robertgabriel.entities;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Basic;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;

@Document
@Table(name = "todolists")
public class TodoList implements Serializable{

    private String id;

    private String title;

    private String description;

    private List<Item> items;

    @Id
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
