package com.dms.document_management.models;
import java.util.Collection;

import jakarta.persistence.Entity;
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
    private boolean enablled
    private Collection<Role> roles;

}
