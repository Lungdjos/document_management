package com.dms.document_management.dao
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class User {
    @Id
    private long id;
}
