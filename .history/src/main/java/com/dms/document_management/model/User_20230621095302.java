package com.dms.document_management.model;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class User {
    
    private String fName;
    private String lName;
    private String email;
    private String username;
    private String password;
}
