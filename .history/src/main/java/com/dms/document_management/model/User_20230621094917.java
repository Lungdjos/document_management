package com.dms.document_management.models;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class User {
    @Id
    private long id;
    private String fName;
    private String fEmail;
    private String username;
    private String password;
}
