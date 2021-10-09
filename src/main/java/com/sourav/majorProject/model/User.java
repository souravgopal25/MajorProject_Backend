package com.sourav.majorProject.model;

import org.hibernate.annotations.NotFound;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import javax.persistence.*;

@Entity
@Table(name = "user_table")
public class User {
    @Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "user_sequence")
    private int id;
    @NonNull
    private String password;
    private boolean active;
    @NonNull
    private String roles;
    @NonNull
    private String firstName;
    @NonNull
    private String lastName;
    @NonNull
    private String uid;
    @Nullable
    private String photoUrl;
    @NonNull
    private String email;

    public User( @NonNull String password,  @NonNull String roles, @NonNull String firstName, @NonNull String lastName, @NonNull String uid, @Nullable String photoUrl, @NonNull String email) {
        this.password = password;
        this.active = true;
        this.roles = roles;
        this.firstName = firstName;
        this.lastName = lastName;
        this.uid = uid;
        this.photoUrl = photoUrl;
        this.email = email;
    }

    @NonNull
    public String getPassword() {
        return password;
    }

    public void setPassword(@NonNull String password) {
        this.password = password;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @NonNull
    public String getRoles() {
        return roles;
    }

    public void setRoles(@NonNull String roles) {
        this.roles = roles;
    }

    @NonNull
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(@NonNull String firstName) {
        this.firstName = firstName;
    }

    @NonNull
    public String getLastName() {
        return lastName;
    }

    public void setLastName(@NonNull String lastName) {
        this.lastName = lastName;
    }

    @NonNull
    public String getUid() {
        return uid;
    }

    public void setUid(@NonNull String uid) {
        this.uid = uid;
    }

    @Nullable
    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(@Nullable String photoUrl) {
        this.photoUrl = photoUrl;
    }

    @NonNull
    public String getEmail() {
        return email;
    }

    public void setEmail(@NonNull String email) {
        this.email = email;
    }

    public User() {

    }
}
