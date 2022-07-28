package com.khana.khazana.model;

public class LoginResponse {
    private long userId;
    private boolean status;
    private String Message;
    private String Role;
    private String token;

    public String getRole() {
        return Role;
    }

    public void setRole(String role) {
        Role = role;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }
}
