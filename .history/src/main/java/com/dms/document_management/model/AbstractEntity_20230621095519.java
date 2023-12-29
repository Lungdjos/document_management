package com.dms.document_management.models;

import jakarta.persistence.Id;
@Mapped
public class AbstractEntity {
    @Id
    private long id;
}
