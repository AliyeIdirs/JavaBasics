package com.unitedcoder.homework.week10day3constructor;

public class User {
    private String userName;
    private String password;
    private String role;
    private boolean active;

    public User() {
    }

    public User(String userName, String password, String role, boolean active) {
        this.userName = userName;
        this.password = password;
        this.role = role;
        this.active = active;
    }

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    public boolean isActive() {
        return active;
    }
}

class UserTest{
    public static void main(String[] args) {
        User user= new User("dolkuntarim","automaiton123!","admin",true);
        System.out.println("User Name: "+user.getUserName());
        System.out.println("Password: "+user.getPassword());
        System.out.println("Role: "+user.getRole());
        System.out.println("Is active? "+user.isActive());
    }
}
