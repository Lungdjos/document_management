package com.dms.document_management.model;

import jakarta.persistence.Id;

public abstract class AbstractEntity {
    @Id
    private long id;
}
