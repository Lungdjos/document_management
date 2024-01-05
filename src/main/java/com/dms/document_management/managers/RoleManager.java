package com.dms.document_management.managers;

import com.dms.document_management.models.roles.Role;

public interface RoleManager {
    void addNewRole(String role);
    Role getRole(String role) throws Exception;
}
