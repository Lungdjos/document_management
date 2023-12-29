package com.dms.document_management.models;

import jakarta.persistence.Id;

public abstract class AbstractEntity {
    @Id
    private long id;
}
