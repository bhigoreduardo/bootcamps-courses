package model;

public class User {

    // Attributes
    private int id;
    private String user;
    private String password;

    // Constructor
    public User(int id, String user, String password) {
        this.setId(id);
        this.setUser(user);
        this.setPassword(password);
    }

    public User(String user, String password) {
        this.setUser(user);
        this.setPassword(password);
    }

    // Methods Getters
    public int getId() {
        return id;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    // Methods Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // toString
    @Override
    public String toString() {
        return "User{" + "id=" + id
                + ", user=" + user
                + ", password=" + password + "}";
    }

}
