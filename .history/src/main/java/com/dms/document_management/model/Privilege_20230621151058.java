package com.dms.document_management.model;

import jakarta.persistence.ManyToMany;

public class Privilege extends AbstractEntity {
    private String name;
    @ManyToMany(mappedBy = "privileges")
    private Collection<Role> roles;
}
