package com.tusry.coffee.ntcoffee.entity;
// tương lai sẽ là @Entity
public class Account {
    private String username;
    private String password;
    private int role; // 1:admin, 2: staff

    public Account() {
    }

    public Account(String username, String password, int role) {
        this.username = username;
        this.password = password;
        this.role = role;
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

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }
}
