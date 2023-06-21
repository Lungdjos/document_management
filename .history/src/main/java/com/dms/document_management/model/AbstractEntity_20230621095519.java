package com.dms.document_management.model;

import jakarta.persistence.Id;
@Mapped
public class AbstractEntity {
    @Id
    private long id;
}
