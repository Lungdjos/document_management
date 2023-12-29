package com.dms.document_management.models;

import jakarta.persistence.ManyToMany;

public class Privilege extends AbstractEntity {
    private String name;

    @ManyToMany(mappedBy = "privileges")
    private Collection<Role> roles;
}
