package com.unitedcoder.jsonfile.deserilization.cubecartautomation;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LoginUser {
    @JsonProperty("username")
    private String userName;
    @JsonProperty("password")
    private String password;

    public LoginUser() {
    }

    public LoginUser(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }
}
