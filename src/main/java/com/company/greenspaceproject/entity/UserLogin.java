package com.company.greenspaceproject.entity;

import java.io.Serializable;

public class UserLogin implements Serializable {
    private int id;
    private String email;
    private String password;
    private int locked;
    private int login_attempts;
    private String salt;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setPassword(String passWord) {
        this.password = passWord;
    }

    public String getPassword() {
        return password;
    }

    public void setLocked(int locked) {
        this.locked = locked;
    }

    public int getLocked() {
        return locked;
    }

    public int getLogin_attempts() {
        return login_attempts;
    }

    public void setLogin_attempts(int login_attempts) {
        this.login_attempts = login_attempts;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(int salt) {
        this.salt = String.valueOf(salt);
    }

    @Override
    public String toString() {
        return "UserLogin{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", locked=" + locked +
                ", login_attempts=" + login_attempts +
                ", salt='" + salt + '\'' +
                '}';
    }
}
