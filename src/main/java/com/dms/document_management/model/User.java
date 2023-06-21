package com.dms.document_management.model;
import java.util.Collection;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table
public class User extends AbstractEntity{
    // attributes
    private String fName;
    private String lName;
    private String email;
    private String username;
    private String password;
    private boolean enabled;
    private boolean tokenExpired;
    @ManyToMany
    @JoinTable(name = "users_roles", 
        joinColumns = @JoinColumn(
        name = "user_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(
        name = "role_id", referencedColumnName = "id"))
    private Collection<Role> roles;


    /**
     * @return String return the fName
     */
    public String getFName() {
        return fName;
    }

    /**
     * @param fName the fName to set
     */
    public void setFName(String fName) {
        this.fName = fName;
    }

    /**
     * @return String return the lName
     */
    public String getLName() {
        return lName;
    }

    /**
     * @param lName the lName to set
     */
    public void setLName(String lName) {
        this.lName = lName;
    }

    /**
     * @return String return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return String return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return String return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return boolean return the enabled
     */
    public boolean isEnabled() {
        return enabled;
    }

    /**
     * @param enabled the enabled to set
     */
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    /**
     * @return boolean return the tokenExpired
     */
    public boolean isTokenExpired() {
        return tokenExpired;
    }

    /**
     * @param tokenExpired the tokenExpired to set
     */
    public void setTokenExpired(boolean tokenExpired) {
        this.tokenExpired = tokenExpired;
    }

    /**
     * @return Collection<Role> return the roles
     */
    public Collection<Role> getRoles() {
        return roles;
    }

    /**
     * @param roles the roles to set
     */
    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }

}
