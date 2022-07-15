package model;

import java.util.Date;

public class Project {

    // Attributes
    private int id;
    private String name;
    private String description;
    private Date createdAt;
    private Date updatedAt;

    // Constructor
    public Project(int id, String name, String description, Date createdAt, Date updatedAt) {
        this.setId(id);
        this.setName(name);
        this.setDescription(description);
        this.setCreatedAt(createdAt);
        this.setUpdatedAt(updatedAt);
    }

    public Project() {
        this.createdAt = new Date();
        this.updatedAt = new Date();
    }

    // Methods Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    // Methods Setters]
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    // toString
    @Override
    public String toString() {
        /*
        return "Project{" + "id=" + id
                + ", name=" + name
                + ", description=" + description
                + ", createdAt=" + createdAt
                + ", updatedAt=" + updatedAt + "}";
         */

        return getName();
    }

}
