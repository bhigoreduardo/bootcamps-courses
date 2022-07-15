package model;

import java.util.Date;

public class Task {

    // Attributes
    private int id;
    private int projectId;
    private String name;
    private String description;
    private boolean status;
    private String notes;
    private Date deadline;
    private Date createdAt;
    private Date updatedAt;

    // Constructor
    public Task(int id, int projectId, String name,
            String description, boolean status, String notes, Date deadline,
            Date createdAt, Date updatedAt) {
        this.setId(id);
        this.setProjectId(projectId);
        this.setName(name);
        this.setDescription(description);
        this.setStatus(status);
        this.setNotes(notes);
        this.setDeadline(deadline);
        this.setCreatedAt(createdAt);
        this.setUpdatedAt(updatedAt);
    }

    public Task() {
        this.createdAt = new Date();
        this.updatedAt = new Date();
    }

    // Methods Getters
    public int getId() {
        return id;
    }

    public int getProjectId() {
        return projectId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public boolean getStatus() {
        return status;
    }

    public String getNotes() {
        return notes;
    }

    public Date getDeadline() {
        return deadline;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    // Methods Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
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
        return "TaskController{" + "id=" + id
                + ", projectId=" + projectId
                + ", name=" + name
                + ", description=" + description
                + ", status=" + status
                + ", notes=" + notes
                + ", deadline=" + deadline
                + ", createdAt=" + createdAt
                + ", updatedAt=" + updatedAt + "}";
    }

}
