package com.company.greenspaceproject.entity;

import java.io.Serializable;

public class Register implements Serializable {
    private int rid;
    private String email;
    private String password;
    private String salt;
    private String verification_code;


    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getSalt() {
        return salt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setVerification_code(String verification_code) {
        this.verification_code = verification_code;
    }

    public String getVerification_code() {
        return verification_code;
    }

    @Override
    public String toString() {
        return "Register{" +
                "rid=" + rid +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", salt='" + salt + '\'' +
                ", verification_code='" + verification_code + '\'' +
                '}';
    }
}
