package com.dms.document_management.models;
import jakarta.persistence.Entity;

import jakarta.persistence.Table;

@Entity
@Table
public class User extends AbstractEntity{
    private String fName;
    private String lName;
    private String email;
    private String username;
    private String password;
}
