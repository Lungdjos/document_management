package com.dms.document_management.models.user;
import java.util.HashSet;
import java.util.Set;

import com.dms.document_management.models.AbstractEntity;
import com.dms.document_management.models.roles.Role;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@Entity
@Table
public class UserInfo extends AbstractEntity {
    // attributes
    private String fName;
    private String mName;
    private String lName;
    private String email;
    private String username;
    @JsonIgnore
    private String password;
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Role> roles = new HashSet<>();

}
