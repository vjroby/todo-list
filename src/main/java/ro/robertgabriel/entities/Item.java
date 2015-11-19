package ro.robertgabriel.entities;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Basic;
import javax.persistence.Id;
import java.io.Serializable;

//@Entity
@Document(collection = "items")
public class Item implements Serializable{

    private String id;

    private String title;

    private String date;

    private String listId;

    private String description;

    @Basic
    public String getListId() {
        return listId;
    }

    public void setListId(String listId) {
        this.listId = listId;
    }

    @Basic
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Basic
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    @Id
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
