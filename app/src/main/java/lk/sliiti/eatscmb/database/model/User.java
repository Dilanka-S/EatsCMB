package lk.sliiti.eatscmb.database.model;

public class User {
    String username;
    String password;
    String name;
    Boolean logStatus;

    public User(String username, String password, String name, Boolean logStatus) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.logStatus = logStatus;
    }
}
