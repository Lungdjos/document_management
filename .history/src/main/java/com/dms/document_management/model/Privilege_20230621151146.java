package com.dms.document_management.models;

import java.util.Collection;

import jakarta.persistence.ManyToMany;

public class Privilege extends AbstractEntity {
    private String name;
    @ManyToMany(mappedBy = "privileges")
    private Collection<Role> roles;

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

    /**
     * @return Collection<Role> return the roles
     */
    public Collection<Role> getRoles() {
        return roles;
    }

    /**
     * @param roles the roles to set
     */
    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }

}
