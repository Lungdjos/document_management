package com.dms.document_management.models;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public class AbstractEntity {
    // attributes
    @Id
    private long id;
    
}
