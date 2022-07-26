package com.khana.khazana.model;

import javax.persistence.*;

@Entity
@Table(name="userinfo")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;

    @Column(nullable=false, length=20)
    private String username;
    //username is person name
    @Column(nullable=false, length=20, unique = false)
    private String password;

    @Column(nullable=false, length=50, unique = true)
    private String email;

    @Column(nullable=false, length=10, unique = true)
    private String mobile;

    @Column(nullable=false, length=20, unique = false)
    private String role;

    @Column(length=255)
    private String address;

    @Column( length=255)
    private String profilePic;

    private String salt;

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public long getUserId() {
        return userId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(String profilePic) {
        this.profilePic = profilePic;
    }
}
