package ro.robertgabriel.entities;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Basic;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

//@Entity
@Document(collection = "items")
public class Item implements Serializable{

    @GeneratedValue
    @Id
    private String id;

    @NotNull
    private String title;

    private String dueDate;

    @NotNull
    private String listId;

    @NotNull
    private String description;

    @DateTimeFormat
    private Date created = null;

    @DateTimeFormat
    private Date updated = null;

    @Id
    public String getId() {
        return id;
    }

    public void setId(String id) {

        if(id.length() == 0){
            this.id = null;
            return;
        }
        this.id = id;
    }

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
    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String date) {
        this.dueDate = date;
    }

    @Basic
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }
}
