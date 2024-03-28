package com.myblog.myblog12;

public class LoginDto {
    private String username;
    private String password;

    // Constructor
    public LoginDto() {
    }

    // Getter methods
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    // Setter methods
    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Method to return username or email
    public String getUsernameOrEmail() {
        // Here you can return either the username or the email based on your application's logic
        return this.username; // For example, returning the username
    }
}





