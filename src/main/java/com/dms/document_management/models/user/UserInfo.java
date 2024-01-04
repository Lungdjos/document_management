package com.dms.document_management.models.user;
import java.util.HashSet;
import java.util.Set;

import com.dms.document_management.models.abstracts.AbstractEntity;
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
public class UserInfo extends AbstractEntity {
    // attributes
    @NonNull
    private String firstName;
    private String middleName;
    @NonNull
    private String lastName;
    @NonNull
    private String email;
    @NonNull
    private String username;
    @JsonIgnore
    private String password;
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Role> roles = new HashSet<>();

}
