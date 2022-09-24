package lk.sliiti.eatscmb.database.model;

public class User {
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogStatus() {
        return logStatus;
    }

    public void setLogStatus(String logStatus) {
        this.logStatus = logStatus;
    }

    String username;
    String password;
    String name;
    String logStatus;

    public User(String username, String password, String name, String logStatus) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.logStatus = logStatus;
    }
}
