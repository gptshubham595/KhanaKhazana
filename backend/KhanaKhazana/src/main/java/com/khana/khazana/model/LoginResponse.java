package com.khana.khazana.model;

public class LoginResponse {
    private boolean status;
    private String Message;

    public String getRole() {
        return Role;
    }

    public void setRole(String role) {
        Role = role;
    }

    private String Role;
    private String token;


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
