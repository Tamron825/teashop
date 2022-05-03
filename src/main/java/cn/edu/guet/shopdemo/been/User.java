package cn.edu.guet.shopdemo.been;

import java.util.Objects;

public class User {
    private int user_id;
    private String username;
    private String password;
    private int rank;

    public User() {
    }

    public User(int user_id) {
        this.user_id = user_id;
    }

    public User(int user_id, String username, String password, int rank) {
        this.user_id = user_id;
        this.username = username;
        this.password = password;
        this.rank = rank;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

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

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return user_id == user.user_id &&
                rank == user.rank &&
                Objects.equals(username, user.username) &&
                Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user_id, username, password, rank);
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", rank=" + rank +
                '}';
    }
}
