package com.dms.document_management.models;

import jakarta.persistence.Entity;

@Entity
public class Role extends AbstractEntity {
    // attributes
    private String name;

    /**
     * @return String return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

}
