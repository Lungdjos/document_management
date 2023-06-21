package com.dms.document_management.model;

import jakarta.annotation.Generated;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public class AbstractEntity {
    // attributes
    @Id
    @Generated
    private long id;

    /**
     * @return long return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(long id) {
        this.id = id;
    }

}
