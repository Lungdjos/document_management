package com.dms.document_management.model;
import java.util.Collection;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinTable;
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
    @JoinTable(name = ""users_roles", 
        joinColumns = @JoinColumn(
          name = "user_id", referencedColumnName = "id"), 
        inverseJoinColumns = @JoinColumn(
          name = "role_id", referencedColumnName = "id"))
    private Collection<Role> roles;

}
